public class Wolf extends Carnivore {

    /**
     * Creates a new wolf object
     * @param age The wolf's age
     * @param name The wolf's name
     */
    public Wolf(Integer age, String name){
        super(age, name);
    }

    /**
     * Creates a new wolf
     */
    public Wolf(){
        super();
    }

    /**
     * The wolf barks
     */
    public void makeNoise(){
        System.out.println("Bark");
    }

}
