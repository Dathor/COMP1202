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
     * Creates a new parrot
     * @param age The parrot's age
     */
    public Parrot(Integer age){
        super(age, "Polly");
    }

    /**
     * Creates a new parrot
     */
    public Parrot(){
        super();
    }

    /**
     * THe parrot talks
     */
    public void makeNoise(){
        System.out.println("I can talk");
    }
}

