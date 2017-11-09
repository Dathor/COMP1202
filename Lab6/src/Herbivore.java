public abstract class Herbivore extends Animal {

    public Herbivore(Integer age, String name){
        super(age,name);
    }

    public void eat(Food food) throws Exception{
        if(food instanceof Plant){
            System.out.println(this.getName() + " has eaten " + food.getName());
            return;
        }
        throw new Exception("Herbivores eat only plants");
    }
}
