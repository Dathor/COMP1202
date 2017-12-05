import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlashCardReader {

    private BufferedReader reader;

    /**
     * Creates a new flash card reader
     */
    public FlashCardReader(){
        try {
            reader = new BufferedReader(new FileReader("Question.txt"));
        } catch(FileNotFoundException e){
            System.err.println("Unable to open file");
        }
    }

    /**
     * Reads the a line from the file
     * @return
     */
    public String getLine(){
        try{
            return reader.readLine();
        } catch (IOException e){
            return "Unable to read file";
        }
    }

    /**
     * Checks if the file is ready to read from
     * @return
     */
    public boolean isReady(){
        try{
            return reader.ready();
        } catch (IOException e){
            return false;
        }
    }

    /**
     * Add flash cards to an array list
     * @return The list of cards
     */
    public ArrayList<FlashCard> getFlashCards(){
        ArrayList<FlashCard> flashCards = new ArrayList<>();
        flashCards.add(new FlashCard("1", "1"));
        flashCards.add(new FlashCard("2", "2"));
        flashCards.add(new FlashCard("3", "3"));
        flashCards.add(new FlashCard("4", "4"));
        flashCards.add(new FlashCard("5", "5"));
        flashCards.add(new FlashCard("6", "6"));
        return flashCards;
    }
}
