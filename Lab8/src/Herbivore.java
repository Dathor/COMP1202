public abstract class Herbivore extends Animal {

    /**
     * Creates a new herbivore object
     * @param age The herbivore's age
     * @param name The herbivore's name
     */
    public Herbivore(Integer age, String name){
        super(age,name);
    }

    /**
     * Creates a new herbivore
     */
    public Herbivore(){
        super();
    }

    /**
     * The herbivore eats
     * @param food The food
     * @throws Exception Thrown when it's given meat
     */
    public void eat(Food food) throws Exception{
        if(food instanceof Plant){
            System.out.println(this.getName() + " has eaten " + food.getName());
            return;
        }
        throw new Exception("Herbivores eat only plants");
    }

    /**
     * The herbivore eats many times
     * @param food The food
     * @param times How many times is the food eaten
     * @throws Exception Thrown when it's given meat
     */
    public void eat(Food food, int times) throws Exception{
        if(food instanceof Plant){
            for(int i = 0; i < times; i++){
                System.out.println(this.getName() + " has eaten " + food.getName());
            }
            return;
        }
        throw new Exception("Herbivores eat only plants");
    }
}
