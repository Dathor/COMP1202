public class Cow extends Herbivore {

    /**
     * Creates a new cow object
     * @param age The cow's age
     * @param name The cow's name
     */
    public Cow(Integer age, String name){
        super(age, name);
    }

    /**
     * The cow moos
     */
    public void makeNoise(){
        System.out.println("Moo");
    }
}
