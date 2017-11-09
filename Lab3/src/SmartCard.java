public class SmartCard {

    private String Owner;
    private boolean IsStaff;


    /**
     * Creates a new smart card
     * @param owner The name of the card owner
     */
    public SmartCard(String owner){
        Owner = owner;
        IsStaff = false;
    }

    /**
     * Gets the owner of the card
     * @return The owner
     */
    public String getOwner(){
        return Owner;
    }

    /**
     * Checks if the owner of the card is part of the staff
     * @return Is the owner staff
     */
    public boolean isStaff(){
        return IsStaff;
    }


    /**
     * Sets the position of the owner of the card
     * @param isStaff Is the owner staff
     */
    public void setStaff(boolean isStaff){
        IsStaff = isStaff;
    }
}
