public abstract class Animal {
    protected Integer age;
    protected String name;

    /**
     * Creates a new animal object
     * @param age The animal's age
     * @param name The animal's name
     */
    public Animal(Integer age, String name){
        this.age = age;
        this.name = name;
    }

    /**
     * Gets the animal's age
     * @return The age of the animal
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Gets the animal's name
     * @return The name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * The animal makes noise
     */
    public abstract void makeNoise();

    /**
     * The animal eats given food
     * @param food The food
     * @throws Exception Thrown when given wrong food
     */
    public abstract void eat(Food food) throws Exception;
}
