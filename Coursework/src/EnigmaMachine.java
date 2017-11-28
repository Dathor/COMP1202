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
            this.rotors[slot].rotate(true);
        }
    }


    public char encodeLetter(char letter){
        letter = this.plugboard.substitute(letter);

        int index = (int) letter;
        index -= 65;

        for(int i = 0; i < 3; i++){
            index = this.rotors[i].substitute(index);
        }

        index = this.reflector.substitute(index);

        for(int i = 2; i >= 0; i--){
            index = this.rotors[i].substituteBack(index);
        }

        index += 65;

        this.rotors[0].rotate(false);

        return this.plugboard.substitute((char) index);


    }

//    public void start(){
//        this.addPlug('b', 'c');
//        this.addPlug('r', 'i');
//        this.addPlug('s', 'm');
//        this.addPlug('a', 'f');
//        this.addRotor(new BasicRotor("IV"), 0);
//        this.setPosition(0, 23);
//        this.addRotor(new BasicRotor("V"), 1);
//        this.setPosition(1, 4);
//        this.addRotor(new BasicRotor("II"), 2);
//        this.setPosition(2, 9);
//        this.addReflector(new Reflector("ReflectorII"));
//        System.out.print(this.encodeLetter('g'));
//        System.out.print(this.encodeLetter('a'));
//        System.out.print(this.encodeLetter('c'));
//        System.out.print(this.encodeLetter('i'));
//        System.out.print(this.encodeLetter('g'));
//    }
}
