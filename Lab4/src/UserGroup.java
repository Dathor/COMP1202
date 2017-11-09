import java.util.ArrayList;
import java.util.Iterator;

public class UserGroup {

    public ArrayList<User> users;


    /**
     * Creates a new user group
     */
    public UserGroup(){
        users = new ArrayList<User>();
    }

    /**
     * Adds sample data to the user group
     */
    public void addSampleData(){
        users.add(new User("fj0", "user", "Francis"));
        users.add(new User("fj1", "admin", "Francis"));
        users.add(new User("fj2", "editor", "Francis"));
        users.add(new User("fj3", "user", "Francis"));
        users.add(new User("fj4", "admin", "Francis"));
        users.add(new User("fj5", "user", "Francis"));
        users.add(new User("fj6", "editor", "Francis"));
        users.add(new User("fj7", "user", "Francis"));
        users.add(new User("fj8", "user", "Francis"));
        users.add(new User("fj9", "admin", "Francis"));
    }

    /**
     * Gets a user from the user group
     * @param index The user's index
     * @return The user
     */
    public User getUser(int index){
        return users.get(index);
    }

    /**
     * Prints all usernames and their types
     */
    public void printUsernames(){
        for(User user : users){
            System.out.println(user.getUsername() + " " + user.getUsertype());
        }
    }

    /**
     * Removes the first user from the group
     */
    public void removeFirstUser(){
        users.remove(0);
    }

    /**
     * Removes the last user from the group
     */
    public void removeLastUser(){
        users.remove(users.size() - 1);
    }

    /**
     * Removes an user from the group
     * @param username The user's username
     */
    public void removeUser(String username){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User current = iterator.next();
            if(current.getUsername().equals(username)){
                iterator.remove();
            }
        }
    }

    /**
     * Returns an iterator from the users array list
     * @return The iterator
     */
    public Iterator<User> getUserIterator(){
        return users.iterator();
    }
}
