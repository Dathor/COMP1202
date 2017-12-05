import java.io.*;
import java.util.ArrayList;

public class Quiz {

    private FlashCardReader flashCardReader;
    private ArrayList<FlashCard> flashCards;

    /**
     * Creates a new quiz
     */
    public Quiz(){
        this.flashCardReader = new FlashCardReader();
        this.flashCards = this.flashCardReader.getFlashCards();
        this.play();
    }

    /**
     * Reads an input from the console
     * @return The input
     */
    private String readFromConsole(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = new String();

        try {
            input = br.readLine();
        } catch (IOException ioe) {
            System.err.println("There was an input error");
        }
        return input;
    }

    /**
     * Gets the percent of right answers
     * @param points The points scored by the player
     * @param allQuestions The number of all questions
     * @return
     */
    private int getPercent(int points, int allQuestions){
        float division = (float) points / (float) allQuestions;

        division *= 100;

        return (int) division;
    }

    /**
     * Play the quiz
     */
    public void play(){
        System.out.println("Do you want to save your results?(y/n)");
        String input = this.readFromConsole();
        int rightAnswers = 0;

        // Resets the file
        if(input.equals("y")){
            this.save("", false);
        }

        for(int i = 0; i < this.flashCards.size(); i++) {
            System.out.println("Question " + i + ": " + flashCards.get(i).getQuestion());
            String answer = this.readFromConsole();

            if (answer.equals(flashCards.get(i).getAnswer())) {
                System.out.println("Correct");
                // Save to the file
                if(input.equals("y")){
                    rightAnswers++;
                    this.save(flashCards.get(i).getQuestion() + ", " + answer + ", " + "right", true);
                }
            } else {
                System.out.println("Wrong answer");
                System.out.println("Correct answer is " + flashCards.get(i).getAnswer());
                // Save to the file
                if(input.equals("y")){
                    this.save(flashCards.get(i).getQuestion() + ", " + answer + ", " + "wrong", true);
                }
            }
        }
        // Final line
        if(input.equals("y")){
            this.save(rightAnswers + ", " + flashCards.size() + ", " + this.getPercent(rightAnswers, flashCards.size()) + "%", true);
        }
    }

    /**
     * Save a line to the save.txt file
     * @param line The line to be saved
     * @param append True if you want to reset the file
     */
    public void save(String line, boolean append){
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("save.txt", append));
            writer.println(line);
            writer.close();
        } catch (IOException e){
            System.out.println("Unable to write to file");
        }
    }
}
