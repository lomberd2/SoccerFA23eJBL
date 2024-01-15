import java.util.Random;

public class Player extends Person {

    protected int force; // 1-10
    protected int powerAtGoalKick; // 1-10
    protected int motivation; // 1-10
    protected int numberOfGoals;

    public Player(String name, int age) {
        super(name, age);
    }

    public Player(String name, int age, int force, int powerAtGoalKick, int motivation, int numberOfGoals) {
        super(name, age);
        this.force = super.validate(force);
        this.powerAtGoalKick = super.validate(powerAtGoalKick);
        this.motivation = super.validate(motivation);
        this.numberOfGoals = numberOfGoals;
    }

    public int shootAtGoal() {
        int rdmInt = new Random().nextInt(-2,1);
        int actualPowerAtGoalKick = this.powerAtGoalKick + rdmInt;

        return super.validate(actualPowerAtGoalKick);
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
