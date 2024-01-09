public abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Validates a given integer value. The value must be between 1 and 10.
     * @param value integer value to validate
     * @return validated integer value
     */
    protected int validate(int value) {
        if (value < 1) {
            return 1;
        } else return Math.min(value, 10);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
