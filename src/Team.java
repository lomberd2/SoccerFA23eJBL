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
        float totalMotivation = 0;
        for (Player player : this.squad) {
            totalMotivation += player.getMotivation();
        }
        return Math.round(totalMotivation / this.squad.size());
    }

    public int getTotalForce() {
        float totalForce = 0;

        totalForce += this.goalkeeper.getForce();

        // add first 10 players of team
        for (int i = 0; i < 10 && (i < this.squad.size()); i++) {
            totalForce += this.squad.get(i).getForce();
        }

        return Math.round(totalForce / 11);
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
