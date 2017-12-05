public class BasicRotor extends Rotor {

    private int[] inverseMapping;

    /**
     * Initialises the rotor
     * @param name The type of the rotor
     */
    public void initialise(String name){
        this.name = name;
        if(name.equals("I")){
            this.mapping = new int[]{ 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
        }
        if(name.equals("II")){
            this.mapping = new int[]{ 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
        }
        if(name.equals("III")){
            this.mapping = new int[]{ 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
        }
        if(name.equals("IV")){
            this.mapping = new int[]{ 4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
        }
        if(name.equals("V")){
            this.mapping = new int[]{ 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
        }
    }

    /**
     * Creates a new rotor
     * @param name The type of the rotor
     */
    public BasicRotor(String name){
        this.initialise(name);
        this.position = 0;
        this.inverseMapping = new int[26];
        int count = 0;
        for(int i: this.mapping){
            this.inverseMapping[i] = count;
            count++;
        }

    }

    /**
     * Substitutes a letter using a mapping
     * @param character The index of the letter
     * @param mapping The mapping (normal or inverse)
     * @return The substituted letter
     */
    private int basicSubstitution(int character, int[] mapping){
        if(character - this.position >= 0){
            if(mapping[character - this.position] + this.position >= ROTORSIZE){
                return mapping[character - this.position] + this.position - ROTORSIZE;
            }
            return mapping[character - this.position] + this.position;
        } else {
            if(mapping[ROTORSIZE + (character - this.position)] + this.position >= ROTORSIZE){
                return mapping[ROTORSIZE + (character - this.position)] + this.position - ROTORSIZE;
            }
            return mapping[ROTORSIZE + (character - this.position)] + this.position;
        }
    }

    /**
     * Substitutes a letter using the normal mapping
     * @param character The index of the letter
     * @return The substituted letter
     */
    public int substitute(int character){
        return basicSubstitution(character, this.mapping);
    }

    /**
     * Substitutes a letter using the inverse mapping
     * @param character The index of the letter
     * @return The substituted letter
     */
    public int substituteBack(int character){
       return basicSubstitution(character, this.inverseMapping);
    }

    /**
     * Rotates the rotor once
     * @param firstRotation True if called in the set position method
     */
    public void rotate(boolean firstRotation){
        if(this.position == ROTORSIZE - 1){
            this.position = 0;
            return;
        }
        this.position++;
    }
}
