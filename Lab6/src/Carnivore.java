public abstract class Carnivore extends Animal {

    /**
     * Creates a new carnivore object
     * @param age The carnivore's age
     * @param name The carnivore's name
     */
    public Carnivore(Integer age, String name){
        super(age, name);
    }

    /**
     * The carnivore eats
     * @param food The food
     * @throws Exception Thrown when it's given a plant
     */
    public void eat(Food food) throws Exception {
        if(food instanceof Meat) {
            System.out.println(this.getName() + " has eaten " + food.getName());
            return;
        }
        throw new Exception("Carnivores eat only meat");
    }
}
