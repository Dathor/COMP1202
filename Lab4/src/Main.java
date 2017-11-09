import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        // This part prints a multiplication table
        Toolbox toolbox = new Toolbox();
        System.out.println("Part 1.1:");

        int number = toolbox.readIntegerFromCmd();

        for(int i = 0; i < 20; i++){
            System.out.println(number * (i + 1));
        }

        // This part calculates how many successive integers to add to make a total over 500
        int sum = 0;
        int counter = 0;

        while(sum <= 500){
            counter++;
            sum += counter;
        }

        System.out.println("Part 1.2:");
        System.out.println(counter);

        // Creating the user group
        UserGroup userGroup = new UserGroup();
        userGroup.addSampleData();
        userGroup.removeUser("fj3");

        // Printing the users
        System.out.println("Part 2:");
        userGroup.printUsernames();

        // Creating the administrator group
        UserGroup administrators = new UserGroup();

        Iterator<User> itr = userGroup.getUserIterator();

        // Populating the administrator group
        while(itr.hasNext()){
            User current = itr.next();
            if(current.getUsertype() == "admin"){
                administrators.users.add(current);
            }
        }

        // Printing out the administrator
        System.out.println("Part 3.1:");
        administrators.printUsernames();

        // Setting the last administrator as an user
        administrators.users.get(administrators.users.size() - 1).setUserType("user");

        // Printing the two final groups
        System.out.println("Part 3.2:");
        System.out.println("Users:");
        userGroup.printUsernames();
        System.out.println("Admins: ");
        administrators.printUsernames();
    }
}
