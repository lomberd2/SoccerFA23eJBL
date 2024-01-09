public class Coach extends Person {
    protected int experience;

    public Coach(String name, int age, int experience) {
        super(name, age);
        this.experience = super.validate(experience);
    }

    public int getExperience() { return this.experience; }

    @Override public String toString() { return "\nCoach\n" + "name: " + this.name + "\nage: " + this.age + "\nexperience: " + this.experience; }
}
