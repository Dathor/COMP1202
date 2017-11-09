public abstract class Omnivore extends Animal {

    public Omnivore(Integer age, String name){
        super(age, name);
    }


    public void eat(Food food){
        System.out.println(this.getName() + " has eaten " + food.getName());
    }

}
