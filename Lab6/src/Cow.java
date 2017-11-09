public class Cow extends Herbivore {

    public Cow(Integer age, String name){
        super(age, name);
    }

    public void makeNoise(){
        System.out.println("Moo");
    }
}
