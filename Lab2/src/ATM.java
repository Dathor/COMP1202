public class ATM {
    private int Balance;

    private Toolbox MyToolbox = new Toolbox();

    /**
     * Main method used to initialize an account
     */
    public void Go(){
        while(true) {
            System.out.print("Welcome to online ATM banking\nHow much do you want in your account?\n");

            int input = MyToolbox.readIntegerFromCmd();
            // Checking if the number entered is valid amount
            if (input < 0) {
                System.out.print("Invalid balance was entered.\nTry again.\n");
            } else {
                Balance = input;
                Choose();
            }
        }
    }

    /**
     * Prints the main menu and redirects after a choice is made
     */
    private void Choose() {
        while(true) {
            System.out.print("1 : Withdraw\n" +
                    "2 : Deposit\n" +
                    "3 : Inquire\n" +
                    "4 : Quit\n");
            int choice = MyToolbox.readIntegerFromCmd();
            // Redirecting after a choice is made
            if (choice == 1) {
                Withdraw();
            } else if (choice == 2) {
                Deposit();
            } else if (choice == 3) {
                Balance();
            } else if (choice == 4) {
                Quit();
            } else {
                System.out.print("Invalid choice.\nTry again.\n");
            }
        }
    }

    /**
     * Withdraws money from the account
     */
    private void Withdraw() {
        while(true) {
            System.out.print("*****************************************\n" +
                    "              Withdrawal                 \n" +
                    "*****************************************\n");
            System.out.print("How much would you like to withdraw?\n");
            int amount = MyToolbox.readIntegerFromCmd();
            // Checking if the number entered is valid amount
            if (amount < 0 || amount > Balance) {
                System.out.print("Invalid withdraw amount was entered.\nTry again.\n");
            } else {
                Balance = Balance - amount;
                Choose();
            }
        }
    }

    /**
     * Deposits money in the account
     */
    private void Deposit() {
        while(true) {
            System.out.print("*****************************************\n" +
                    "              Deposit                 \n" +
                    "*****************************************\n");
            System.out.print("How much would you like to Deposit?\n");
            int amount = MyToolbox.readIntegerFromCmd();
            // Checking if the number entered is valid amount
            if (amount < 0) {
                System.out.print("Invalid deposit amount was entered.\nTry again.\n");
            } else {
                Balance = Balance + amount;
                Choose();
            }
        }
    }

    /**
     * Prints out the balance of the account
     */
    private void Balance() {
        System.out.print("****************************************\n" +
                "          Your balance is " + String.valueOf(Balance) + "\n" +
                "*****************************************\n");
        Choose();
    }

    /**
     * Stops the application
     */
    private void Quit() {
        System.out.print("******************************************\n" +
                "         GoodBye!\n" +
                "******************************************\n");

        System.exit(0);
    }
}
