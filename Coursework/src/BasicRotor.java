public class BasicRotor extends Rotor {

    public void initialise(String name){
        this.name = name;
        if(name == "I"){
            this.mapping = new int[]{ 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
        }
        if(name == "II"){
            this.mapping = new int[]{ 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
        }
        if(name == "III"){
            this.mapping = new int[]{ 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
        }
        if(name == "IV"){
            this.mapping = new int[]{ 4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
        }
        if(name == "V"){
            this.mapping = new int[]{ 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
        }
    }

    public BasicRotor(String name){
        this.initialise(name);
        this.position = 0;
    }

    private int basicSubstitution(int character, int[] mapping){
        if(character - this.position >= 0){
            if(mapping[character - this.position] + this.position > ROTORSIZE){
                return mapping[character - this.position] + this.position - ROTORSIZE;
            }
            return mapping[character - this.position] + this.position;
        } else {
            if(mapping[ROTORSIZE + (character - this.position)] + this.position > ROTORSIZE){
                return mapping[ROTORSIZE + (character - this.position)] + this.position - ROTORSIZE;
            }
            return mapping[ROTORSIZE + (character - this.position)] + this.position;
        }
    }

    public int substitute(int character){
        return basicSubstitution(character, this.mapping);
    }
    
    public int substituteBack(int character){
        int[] inverseMapping = new int[26];
        int count = 0;
        for(int i: this.mapping){
            inverseMapping[i] = count;
            count++;
        }
       return basicSubstitution(character, inverseMapping);
    }

    public void rotate(){
        if(this.position == ROTORSIZE){
            this.position = 0;
        } else {
            this.position++;
        }
    }
}
