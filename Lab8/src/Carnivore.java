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
     * Creates a new carnivore
     */
    public Carnivore(){
        super();
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

    /**
     * The carnivore eats many times
     * @param food The food
     * @param times How many times is the food eaten
     * @throws Exception Тhrown when given a plant
     */
    public void eat(Food food, int times) throws Exception {
        if(food instanceof Meat) {
            for (int i = 0; i < times; i++) {
                System.out.println(this.getName() + " has eaten " + food.getName());
            }
            return;
        }
        throw new Exception("Carnivores eat only meat");
    }
}
