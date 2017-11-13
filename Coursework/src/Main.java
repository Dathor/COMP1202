public class Main {

    public static void main(String[] args) {

        //EnigmaMachine em = new EnigmaMachine();

        EnigmaFile ef = new EnigmaFile();

        //em.start();

        ef.decodeFile("test.txt", "textDecoded.txt");

    }
}
