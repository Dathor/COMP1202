import java.io.*;

public class EnigmaFile {

    private EnigmaMachine enigmaMachine;
    private FileReader reader;
    private FileWriter writer;

    /**
     * Creates a new enigma machine file writer
     * @param em The enigma machine
     */
    public EnigmaFile(EnigmaMachine em){
        this.enigmaMachine = em;
    }

    /**
     * Decodes a string from a file
     * @param fileToDecode The file to decode from
     * @param targetFile The file to write to
     */
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
