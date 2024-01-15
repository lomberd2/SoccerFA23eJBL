import java.util.Random;

public class Goalkeeper extends Player {
    private final int reaction;

    public Goalkeeper(String name, int age, int force, int powerAtGoalKick, int motivation, int reaction) {
        super(name, age, force, powerAtGoalKick, motivation, 0);
        this.reaction = super.validate(reaction);
    }

    public boolean ballHold(int powerAtGoalKick) {
        int randomInt = new Random().nextInt(-1,1);
        int actualPowerAtGoalKick = powerAtGoalKick + randomInt;

        // Validate first
        actualPowerAtGoalKick = super.validate(actualPowerAtGoalKick);

        // Compare if reaction is equal or greater than actualPowerAtGoalKick then return true
        return this.reaction >= actualPowerAtGoalKick;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
