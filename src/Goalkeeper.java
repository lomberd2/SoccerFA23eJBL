public class Goalkeeper extends Player {
    private int reaction;

    public Goalkeeper(String name, int age, int force, int powerAtGoalKick, int motivation, int reaction) {
        super(name, age, force, powerAtGoalKick, motivation, 0);
        this.reaction = super.validate(reaction);
    }

    public boolean ballHold(int powerAtGoalKick) {
        // 1, 2 or 3
        int randomInt = (int) (Math.random() * 3 + 1);
        System.out.println("randomInt: " + randomInt);

        int actualPowerAtGoalKick = powerAtGoalKick;

        switch (randomInt) {
            case 1:
                // -1
                actualPowerAtGoalKick--;
            case 2:
                // Nothing
            case 3:
                // +1
                actualPowerAtGoalKick++;
        }

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
