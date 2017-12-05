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
     * Creates a new omnivore
     */
    public Omnivore(){
        super();
    }


    /**
     * The omnivore eats
     * @param food The food
     */
    public void eat(Food food){
        System.out.println(this.getName() + " has eaten " + food.getName());
    }

    /**
     * The omnivore eats
     * @param food The food
     * @param times How many times is the food eaten
     */
    public void eat(Food food, int times) {
        for(int i = 0; i < times; i++){
            System.out.println(this.getName() + " has eaten " + food.getName());
        }
    }

}
