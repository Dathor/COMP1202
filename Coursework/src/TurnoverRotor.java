public class TurnoverRotor extends BasicRotor {

    private int turnoverPosition;
    private BasicRotor nextRotor;

    /**
     * Creates a new turnover rotor
     * @param name The type of the rotor
     * @param nextRotor The next rotor
     */
    public TurnoverRotor(String name, BasicRotor nextRotor){
        super(name);
        if(this.name.equals("I")){
            this.turnoverPosition = 24;
        }
        if(this.name.equals("II")){
            this.turnoverPosition = 12;
        }
        if(this.name.equals("III")){
            this.turnoverPosition = 3;
        }
        if(this.name.equals("IV")){
            this.turnoverPosition = 17;
        }
        if(this.name.equals("V")){
            this.turnoverPosition = 7;
        }

        this.nextRotor = nextRotor;
    }

    /**
     * Creates a new rotor
     * @param name The type of the rotor
     */
    public TurnoverRotor(String name){
        super(name);
        if(this.name.equals("I")){
            this.turnoverPosition = 24;
        }
        if(this.name.equals("II")){
            this.turnoverPosition = 12;
        }
        if(this.name.equals("III")){
            this.turnoverPosition = 3;
        }
        if(this.name.equals("IV")){
            this.turnoverPosition = 17;
        }
        if(this.name.equals("V")){
            this.turnoverPosition = 7;
        }
    }

    /**
     * Sets the next rotor
     * @param nextRotor The next rotor
     */
    public void setNextRotor(BasicRotor nextRotor){
        this.nextRotor = nextRotor;
    }

    /**
     * Rotates the rotor once
     * @param firstRotation True if called in the set position method
     */
    @Override
    public void rotate(boolean firstRotation){
        if(this.position == ROTORSIZE - 1){
            this.position = 0;
            return;
        }
        this.position++;
        if(this.position  == this.turnoverPosition && firstRotation == false && this.nextRotor != null){
            nextRotor.rotate(false);
        }
    }

}
