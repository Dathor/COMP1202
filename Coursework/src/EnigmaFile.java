import java.io.*;

public class EnigmaFile {

    private EnigmaMachine enigmaMachine;
    private FileReader reader;
    private FileWriter writer;

    public EnigmaFile(){
        this.enigmaMachine = new EnigmaMachine();
        this.enigmaMachine.addPlug('b', 'c');
        this.enigmaMachine.addPlug('r', 'i');
        this.enigmaMachine.addPlug('s', 'm');
        this.enigmaMachine.addPlug('a', 'f');
        this.enigmaMachine.addRotor(new BasicRotor("IV"), 0);
        this.enigmaMachine.setPosition(0, 23);
        this.enigmaMachine.addRotor(new BasicRotor("V"), 1);
        this.enigmaMachine.setPosition(1, 4);
        this.enigmaMachine.addRotor(new BasicRotor("II"), 2);
        this.enigmaMachine.setPosition(2, 9);
        this.enigmaMachine.addReflector(new Reflector("ReflectorII"));
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
