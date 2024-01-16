import java.util.Random;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME = 5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;

    private final Game game;

    public Gameplay(Game game) {
        this.game = game;
    }

    private void doGameAction(Player player, Goalkeeper goalkeeper, int minute, Team team) {
        System.out.println(minute + ". Minute:");
        System.out.println("Chance für " + team.getName() + " ...");

        System.out.println(player.name + " zieht ab");
        int playerShootForce = player.shootAtGoal();

        delay();

        if (goalkeeper.ballHold(playerShootForce)) {
            System.out.println(goalkeeper.name + " pariert glanzvoll");

        } else {
            this.game.increaseGoalByPlayer(player);
            System.out.println("TOR!!!   " + game.getScore() + " " + player.name + "(" + player.numberOfGoals + ")");

        }

        System.out.print("\n");

        delay();
    }

    private void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play()
    {
        // Print VS msg
        System.out.println("Spiel: " + this.game.getHome().getName() + " vs " + this.game.getAway().getName());

        // Ermittel wie lange das Spiel dauert (mind. Spielzeit <-> max. Spielzeit + max. Nachspielzeit)
        int duration = PLAYING_TIME + new Random().nextInt(MAX_ADDITIONAL_TIME);

        int lastActionMinute = 0;
        int nextActionMinute = 0;

        // Spiel loop
        for (int minute = 0; minute < duration; minute++) {
            if (minute == 0) {
                System.out.println("Anpfiff");
            } else {

                // Check if next action is reached
                if (minute < nextActionMinute) {
                    continue;
                }

                lastActionMinute = minute;
            }

            // Ermittle welche Mannschaft aktuell am Ball ist
            Team currentTeam;
            Team otherTeam;
            int homeTeamForce = calculateForceOfTheTeam(this.game.getHome());
            int awayTeamForce = calculateForceOfTheTeam(this.game.getAway());
            int randomInt = new Random().nextInt(homeTeamForce + awayTeamForce);

            if (randomInt > homeTeamForce)
            {
                currentTeam = this.game.getAway();
                otherTeam = this.game.getHome();
            }
            else
            {
                currentTeam = this.game.getHome();
                otherTeam = this.game.getAway();
            }

            // Ermittle welcher Spieler aktuell am Ball ist
            Player currentPlayer = currentTeam.getRandomPlayer();
            Goalkeeper otherTeamGoalkeeper = otherTeam.getGoalkeeper();

            this.doGameAction(currentPlayer, otherTeamGoalkeeper, minute, currentTeam);

            // Get Next action (Mind 1 min warten)
            nextActionMinute = (lastActionMinute + 1) + new Random().nextInt(MAX_DURATION_UNTIL_NEXT_ACTION);

        }

        // Print end msg (Ermittele Sieger)
        System.out.println("Abpfiff");
        System.out.println("Endstand: " + this.game.getScoreWithTeamNames());

        if (this.game.getGoalsHome() > this.game.getGoalsAway()) {
            System.out.println(this.game.getHome().getName() + " hat gewonnen");
        } else if (this.game.getGoalsHome() < this.game.getGoalsAway()) {
            System.out.println(this.game.getAway().getName() + " hat gewonnen");
        } else {
            System.out.println("Unentschieden");
        }
    }

    public int calculateForceOfTheTeam(Team team) {
        int tempProd = team.getTotalForce() * team.getTotalMotivation() * team.getCoach().getExperience();
        // -3 bis +3 (using library)
        int tempRnd = new Random().nextInt(-3, 3);

        int tempForce = tempProd + tempRnd;

        //Safety check
        if (tempForce < 1) {
            tempForce = 1;
        }

        return tempForce;
    }
}
