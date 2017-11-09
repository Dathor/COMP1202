public class EnigmaMachine {

    private Plugboard plugboard;
    private BasicRotor[] rotors;
    private Reflector reflector;

    public EnigmaMachine(){
        this.plugboard = new Plugboard();
        this.rotors = new BasicRotor[3];
    }

    public void addPlug(char end1, char end2){
        this.plugboard.addPlug(end1, end2);
    }

    public void clearPlugboard(){
        this.plugboard.clear();
    }

    public void addRotor(BasicRotor rotor, int slot){
        this.rotors[slot] = rotor;
    }

    public BasicRotor getRotor(int slot) {
        return rotors[slot];
    }

    public void addReflector(Reflector reflector){
        this.reflector = reflector;
    }

    public void setPosition(int slot, int position){
        while(this.rotors[slot].getPosition() != position){
            this.rotors[slot].rotate();
        }
    }

    public char encodeLetter(char letter){
        letter = this.plugboard.substitute(letter);
        int index = (int) letter;
        if(index >= 97){
            index -= 97;
        } else{
            index -= 65;
        }
        for(int i = 0; i < 3; i++){
            index = this.rotors[i].substitute(index);
        }

        index = this.reflector.substitute(index);

        for(int i = 2; i >= 0; i--){
            index = this.rotors[i].substitute(index);
        }

        index += 97;

        return this.plugboard.substitute((char) index);


    }

    public void start(){
        this.addPlug('a', 'm');
        this.addPlug('g', 'l');
        this.addPlug('e', 't');
        this.addRotor(new BasicRotor("I"), 0);
        this.setPosition(0, 6);
        this.addRotor(new BasicRotor("II"), 1);
        this.setPosition(1, 12);
        this.addRotor(new BasicRotor("III"), 2);
        this.setPosition(2, 5);
        this.addReflector(new Reflector("ReflectorI"));
        System.out.print(this.encodeLetter('g'));
        System.out.print(this.encodeLetter('f'));
        System.out.print(this.encodeLetter('w'));
        System.out.print(this.encodeLetter('i'));
        System.out.print(this.encodeLetter('q'));
        System.out.print(this.encodeLetter('h'));
    }
}
