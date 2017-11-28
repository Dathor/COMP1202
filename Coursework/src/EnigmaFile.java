import java.io.*;

public class EnigmaFile {

    private EnigmaMachine enigmaMachine;
    private FileReader reader;
    private FileWriter writer;

    public EnigmaFile(){
        this.enigmaMachine = new EnigmaMachine();
        this.enigmaMachine.addPlug('Q', 'F');
//        this.enigmaMachine.addRotor(new BasicRotor("III"), 2);
//        this.enigmaMachine.addRotor(new BasicRotor("II"), 1);
//        this.enigmaMachine.addRotor(new BasicRotor("I"), 0);
        this.enigmaMachine.addRotor(new TurnoverRotor("III", null), 2);
        this.enigmaMachine.addRotor(new TurnoverRotor("II", this.enigmaMachine.getRotor(2)), 1);
        this.enigmaMachine.addRotor(new TurnoverRotor("I",this.enigmaMachine.getRotor(1)), 0);
        this.enigmaMachine.addReflector(new Reflector("ReflectorI"));
        this.enigmaMachine.setPosition(0, 23);
        this.enigmaMachine.setPosition(1, 11);
        this.enigmaMachine.setPosition(2, 7);
    }

    public void decodeFile(String fileToDecode, String targetFile){
        try{
            this.reader = new FileReader(fileToDecode);
            this.writer = new FileWriter(targetFile);

            BufferedReader br = new BufferedReader(this.reader);
            BufferedWriter bw = new BufferedWriter(this.writer);
            int ch;

            while((ch = br.read()) != -1){
                Character encodedChar = this.enigmaMachine.encodeLetter((char) ch);
                bw.write(encodedChar);
            }

            br.close();
            bw.close();
        } catch (FileNotFoundException ex){
            System.out.println("Unable to open file " + fileToDecode);
        } catch (IOException ex){
            System.out.println("Unable to read/write file");
        }
    }
}
