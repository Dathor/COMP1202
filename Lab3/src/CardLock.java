public class CardLock {

    private SmartCard LastCard;
    private boolean StudentAccess;

    /**
     * Creates a new card lock
     */
    public CardLock(){
        StudentAccess = false;
    }

    /**
     * Swipes a card on the lock
     * @param card The card to be swiped
     */
    public void swipeCard(SmartCard card){
        LastCard = card;
    }

    /**
     * Gets the last swiped card
     * @return The last swiped card
     */
    public SmartCard getLastCardSeen() {
        return LastCard;
    }

    /**
     * Checks if the door is unlocked based on the last swiped card
     * @return Is the door unlocked
     */
    public boolean isUnlocked() {
        return (StudentAccess == true) ? true : LastCard.isStaff();
    }

    /**
     * Gives and removes student access
     */
    public void toggleStudentAccess(){
        StudentAccess = !StudentAccess;
    }
}
