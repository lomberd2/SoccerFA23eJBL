import java.util.ArrayList;

public class Team {
    private final String name;
    private final Coach coach;
    private final Goalkeeper goalkeeper;
    private final ArrayList<Player> squad;

    public Team(String name, Coach coach, Goalkeeper goalkeeper) {
        this.name = name;
        this.coach = coach;
        this.goalkeeper = goalkeeper;
        this.squad = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.squad.add(player);
    }

    public int getTotalMotivation() {
        int totalMotivation = 0;
        for (Player player : this.squad) {
            totalMotivation += player.getMotivation();
        }
        return totalMotivation;
    }

    public int getTotalForce() {
        int totalForce = 0;
        for (Player player : this.squad) {
            totalForce += player.getForce();
        }
        return totalForce;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("***Mannschaft***\n");
        stringBuilder.append("Team: ").append(this.name).append("\n");
        stringBuilder.append("Trainer: ").append(this.coach.name).append("\n");
        stringBuilder.append("Torhüter: ").append(this.goalkeeper.name).append("\n");

        for (Player player : this.squad) {
            stringBuilder.append("Spieler: ").append(player.name).append("\n");
        }

        return stringBuilder.toString();
    }
}
