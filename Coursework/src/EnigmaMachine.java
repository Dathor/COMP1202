public class EnigmaMachine {

    private Plugboard plugboard;
    private BasicRotor[] rotors;
    private Reflector reflector;

    /**
     * Creates a new enigma machine
     */
    public EnigmaMachine(){
        this.plugboard = new Plugboard();
        this.rotors = new BasicRotor[3];
    }

    /**
     * Adds a plug to the enigma machine
     * @param end1 The first end of the plug
     * @param end2 The second end of the plug
     */
    public void addPlug(char end1, char end2){
        this.plugboard.addPlug(end1, end2);
    }

    /**
     * Removes all of the plugs from the plugboard
     */
    public void clearPlugboard(){
        this.plugboard.clear();
    }

    /**
     * Adds a rotor to the enigma machine
     * @param rotor The rotor
     * @param slot The rotor's slot
     */
    public void addRotor(BasicRotor rotor, int slot){
        this.rotors[slot] = rotor;
    }

    /**
     * Gets a rotor
     * @param slot The rotor's slot
     * @return The rotor
     */
    public BasicRotor getRotor(int slot) {
        return rotors[slot];
    }

    /**
     * Adds a reflector to the enigma machine
     * @param reflector The reflector
     */
    public void addReflector(Reflector reflector){
        this.reflector = reflector;
    }

    /**
     * Sets the initial position of the rotor
     * @param slot The rotor's slot
     * @param position The position
     */
    public void setPosition(int slot, int position){
        while(this.rotors[slot].getPosition() != position){
            this.rotors[slot].rotate(true);
        }
    }


    /**
     * Encodes a letter
     * @param letter The letter
     * @return The encoded letter
     */
    public char encodeLetter(char letter){
        // Passes the letter through the plugboard
        letter = this.plugboard.substitute(letter);

        // Casts the letter to an int and sets it value from 0 to 25
        int index = (int) letter;
        index -= 65;

        // Passes the letter through the rotors
        for(int i = 0; i < 3; i++){
            index = this.rotors[i].substitute(index);
        }

        // Passes the letter through the reflector
        index = this.reflector.substitute(index);

        // Passes the letter through the rotors back
        for(int i = 2; i >= 0; i--){
            index = this.rotors[i].substituteBack(index);
        }

        // Sets the int to its ascii code
        index += 65;

        // Rotates the first rotor once
        this.rotors[0].rotate(false);

        // Passes the letter through the plugboard and returns it encoded
        return this.plugboard.substitute((char) index);


    }

}
