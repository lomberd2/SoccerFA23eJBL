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

    public void increaseHomeGoals() {
        this.goalsHome++;
    }

    public void increaseAwayGoals() {
        this.goalsAway++;
    }

    public String getScore()
    {
        return this.goalsHome + " : " + this.goalsAway;
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
