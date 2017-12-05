public class FlashCard {

    private String question;
    private String answer;

    /**
     * Creates a new flash card for a question
     * @param question The question
     * @param answer The answer
     */
    public FlashCard(String question, String answer){
        this.answer = answer;
        this.question = question;
    }

    /**
     * Get the question
     * @return The question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Get the answer
     * @return The answer
     */
    public String getAnswer() {
        return answer;
    }
}
