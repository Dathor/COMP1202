public abstract class Carnivore extends Animal {

    public Carnivore(Integer age, String name){
        super(age, name);
    }

    public void eat(Food food) throws Exception {
        if(food instanceof Meat) {
            System.out.println(this.getName() + " has eaten " + food.getName());
            return;
        }
        throw new Exception("Carnivores eat only meat");
    }
}
