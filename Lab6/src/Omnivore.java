public abstract class Omnivore extends Animal {

    /**
     * Creates a new omnivore object
     * @param age The omnivore's age
     * @param name The omnivore's name
     */
    public Omnivore(Integer age, String name){
        super(age, name);
    }


    /**
     * The omnivore eats
     * @param food The food
     */
    public void eat(Food food){
        System.out.println(this.getName() + " has eaten " + food.getName());
    }

}
