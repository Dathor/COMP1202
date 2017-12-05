import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * Read a string from the console
     * @return The entered string
     */
    private String readFromConsole(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = new String();

        try{
            input = br.readLine();
        } catch (IOException ioe){
            System.err.println("There was an input error");
        }

        return input;
    }

    /**
     * Add a rotor to the enigma machine
     * @param isTurnover Is the rotor turnover
     * @param type The type of the rotor
     * @param position The position of the rotor
     * @param em The position of the rotor
     * @param slot The slot of the rotor
     */
    private void addRotor(String isTurnover, String type, String position, EnigmaMachine em, int slot){
        if(isTurnover.equals("y")){
            em.addRotor(new TurnoverRotor(type), slot);
        }
        if(isTurnover.equals("n")){
            em.addRotor(new BasicRotor(type), slot);
        }
        em.setPosition(slot, Integer.parseInt(position));
    }

    /**
     * Checks if a string is a number
     * @param s The string
     * @return True if number
     */
    private boolean isStringANumber(String s){
        try{
            Integer.parseInt(s);
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    /**
     * Checks if an input string is a valid roman number
     * @param s The input string
     * @param isReflector True if checking for a reflector type
     * @return True if the input is valid
     */
    private boolean isStringARomanNumeral(String s, boolean isReflector){
        if(s.equals("I") || s.equals("II")){
            return true;
        }
        if((s.equals("III") || s.equals("IV") || s.equals("V")) && isReflector == false){
            return true;
        }
        return false;
    }

    /**
     * Checks if an input string is a valid input for a plug
     * @param s The string
     * @return True if the input is valid
     */
    private boolean isPlugInputCorrect(String s){
        s = s.replaceAll(" ", "");

        if(s.toCharArray().length == 2){
            if((s.charAt(0) >= 65 && s.charAt(0) <= 90) && (s.charAt(1) >= 65 && s.charAt(1) <= 90)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an input string consists only of capital letters
     * @param message The string
     * @return True if the input is valid
     */
    private boolean isMessageInCorrectFormat(String message){
        for(char current: message.toCharArray()){
            if(current <= 65 || current >= 90){
                return false;
            }
        }
        return true;
    }

    /**
     * Console interface for entering the enigma machine settings
     * @param em The enigma machine settings
     */
    private void setSettings(EnigmaMachine em){
        // Set the plugs
        while (true) {
            System.out.println("How many plugs do you want to add to the plugboard?");
            String plugs = this.readFromConsole();
            if (this.isStringANumber(plugs)) {
                for (Integer i = 0; i < Integer.parseInt(plugs); i++) {
                    String plug;
                    while (true) {
                        System.out.println("What are the 2 letters of the plug?(enter them divided by space)");
                        plug = this.readFromConsole();
                        if (this.isPlugInputCorrect(plug)) {
                            em.addPlug(plug.charAt(0), plug.charAt(1));
                            break;
                        } else {
                            System.out.println("Wrong input.");
                        }
                    }
                }
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        String isTurnover;
        String type;
        String position;

        // Set the first rotor
        while (true) {
            System.out.println("Is the first rotor turnover rotor?(y/n)");
            isTurnover = this.readFromConsole();
            if (isTurnover.equals("y") || isTurnover.equals("n")) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the first rotor type?");
            type = this.readFromConsole();
            if (this.isStringARomanNumeral(type, false)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the initial position of the first rotor?");
            position = this.readFromConsole();
            if (this.isStringANumber(position)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        this.addRotor(isTurnover, type, position, em, 0);

        // Set the second rotor
        while (true) {
            System.out.println("Is the second rotor turnover rotor?(y/n)");
            isTurnover = this.readFromConsole();
            if (isTurnover.equals("y") || isTurnover.equals("n")) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the second rotor type?");
            type = this.readFromConsole();
            if (this.isStringARomanNumeral(type, false)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the initial position of the second rotor?");
            position = this.readFromConsole();
            if (this.isStringANumber(position)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        this.addRotor(isTurnover, type, position, em, 1);

        // Set the third rotor
        while (true) {
            System.out.println("Is the third rotor turnover rotor?(y/n)");
            isTurnover = this.readFromConsole();
            if (isTurnover.equals("y") || isTurnover.equals("n")) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the third rotor type?");
            type = this.readFromConsole();
            if (this.isStringARomanNumeral(type, false)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        while (true) {
            System.out.println("What is the initial position of the third rotor?");
            position = this.readFromConsole();
            if (this.isStringANumber(position)) {
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }

        this.addRotor(isTurnover, type, position, em, 2);

        // Set the next rotors if they are turnover
        if (em.getRotor(0) instanceof TurnoverRotor) {
            ((TurnoverRotor) em.getRotor(0)).setNextRotor(em.getRotor(1));
        }
        if (em.getRotor(1) instanceof TurnoverRotor) {
            ((TurnoverRotor) em.getRotor(1)).setNextRotor(em.getRotor(2));
        }
        if (em.getRotor(2) instanceof TurnoverRotor) {
            ((TurnoverRotor) em.getRotor(2)).setNextRotor(null);
        }

        // Set the reflector
        while (true) {
            System.out.println("What is the type of the reflector?(type just the roman numeral)");
            String reflector = this.readFromConsole();
            if (this.isStringARomanNumeral(reflector, true)) {
                em.addReflector(new Reflector("Reflector" + reflector));
                break;
            } else {
                System.out.println("Wrong input.");
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

        while (true) {
            EnigmaMachine em = new EnigmaMachine();

            // The main menu
            System.out.println("Welcome to the enigma machine.");
            System.out.println("What do you want to do?");
            System.out.println("1 : Decode a message from the console");
            System.out.println("2 : Decode a message from a file");
            System.out.println("3 : Exit");
            System.out.println("Enter your choice:");

            String option = main.readFromConsole();

            if (option.equals("1")) {
                main.setSettings(em);

                // Enter the message to decode
                while (true) {
                    System.out.println("Enter the message to decode:");
                    String message = main.readFromConsole();
                    String decodedMessage = new String();
                    if (main.isMessageInCorrectFormat(message)) {
                        for (char current : message.toCharArray()) {
                            decodedMessage = new StringBuilder(decodedMessage).insert(decodedMessage.length(), em.encodeLetter(current)).toString();
                        }
                        System.out.println(decodedMessage);
                        break;
                    }
                }
            }
            else if(option.equals("2")){
                // Enter the filenames
                main.setSettings(em);
                System.out.println("Enter the name of the file to read from:");
                String inputFile = main.readFromConsole();
                System.out.println("Enter the name of the file to write to:");
                String outputFile = main.readFromConsole();
                EnigmaFile ef = new EnigmaFile(em);
                ef.decodeFile(inputFile, outputFile);
            }
            else if(option.equals("3")){
                break;
            } else{
                System.out.println("Wrong input.");
            }
        }
    }
}
