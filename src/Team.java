import java.util.ArrayList;

public class Team {
    private String name;
    private Coach coach;
    private Goalkeeper goalkeeper;
    private ArrayList<Player> squad;

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
}
