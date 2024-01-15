import java.util.Random;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME = 5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;

    private Game game;

    public Gameplay(Game game) {
        this.game = game;
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
