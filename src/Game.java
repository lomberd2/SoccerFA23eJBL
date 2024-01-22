public class Game {
    private final Team home;
    private final Team away;
    private int goalsHome;
    private int goalsAway;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
        this.goalsHome = 0;
        this.goalsAway = 0;
    }

    public Team getHome() {
        return this.home;
    }

    public Team getAway() {
        return this.away;
    }

    public void increaseHomeGoals() {
        this.goalsHome++;
    }

    public void increaseAwayGoals() {
        this.goalsAway++;
    }

    public void increaseGoalByPlayer(Player player) {
        // First we need to find the players team
        boolean isHomePlayer = this.home.hasPlayer(player);
        player.addGoal();

        if (isHomePlayer) {
            increaseHomeGoals();
            return;
        }

        boolean isAwayPlayer = this.away.hasPlayer(player);
        if (isAwayPlayer) {
            increaseAwayGoals();
            return;
        }

        System.err.println("Player is in no team");
    }

    public String getScore()
    {
        return this.goalsHome + " : " + this.goalsAway;
    }

    public String getScoreWithTeamNames()
    {
        return this.home.getName() + " " + this.goalsHome + " : " + this.goalsAway + " " + this.away.getName();
    }

    public int getGoalsHome() {
        return this.goalsHome;
    }

    public int getGoalsAway() {
        return this.goalsAway;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("***Spiel***\n");
        stringBuilder.append("Heim: ").append(this.home.getName()).append("\n");
        stringBuilder.append("Gast: ").append(this.away.getName()).append("\n");
        stringBuilder.append("Tore Heim: ").append(this.goalsHome).append("\n");
        stringBuilder.append("Tore Gast: ").append(this.goalsAway).append("\n");
        return stringBuilder.toString();
    }
}
