public class Main {

    public static void main(String[] args) {
        TestCalculator testCalculator = new TestCalculator();

        // Testing the parser
        boolean parser = testCalculator.testParser();

        // Testing the addition
        boolean addition = testCalculator.testAdd();

        // Testing the multiplication
        boolean multiplication = testCalculator.testMultiplication();

        if(parser && addition && multiplication){
            System.out.println("Congratulations, your Calculator appears to be working.");
        }
    }
}
