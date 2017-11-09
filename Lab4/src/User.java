public class User {

    private String username;
    private String usertype;
    private String name;

    /**
     * Creates a new user
     * @param username The new user's username
     * @param usertype The new user's type
     * @param name The new user's name
     */
    public User(String username, String usertype, String name){
        this.username = username;
        this.usertype = usertype;
        this.name = name;
    }

    /**
     * Gets the username of the user
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the type of the user
     * @return The user's type
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * Gets the name of the user
     * @return The user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the type of the user
     * @param usertype The type
     */
    public void setUserType(String usertype) {
        this.usertype = usertype;
    }
}
