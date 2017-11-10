public class Parrot extends Omnivore {

    /**
     * Creates a new parrot object
     * @param age The parrot's age
     * @param name The parrot's name
     */
    public Parrot(Integer age, String name){
        super(age, name);
    }

    /**
     * THe parrot talks
     */
    public void makeNoise(){
        System.out.println("I can talk");
    }
}

