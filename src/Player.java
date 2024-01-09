public class Player extends Person {

    protected int force;
    protected int powerAtGoalKick;
    protected int motivation;
    protected int numberOfGoals;

    public Player(String name, int age) {
        super(name, age);
    }

    public Player(String name, int age, int force, int powerAtGoalKick, int motivation, int numberOfGoals) {
        super(name, age);
        this.force = force;
        this.powerAtGoalKick = powerAtGoalKick;
        this.motivation = this.validate(motivation);
        this.numberOfGoals = numberOfGoals;
    }

    public int shootAtGoal() {
        return 0;
    }

    public void addGoal() {
        this.numberOfGoals++;
    }

    public int getForce() {
        return this.force;
    }

    public int getMotivation() {
        return this.motivation;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
