public class Main {

    public static void main(String[] args) {
        System.out.println("Part 1:");
        System.out.println();
        System.out.println("Hello World!");

        System.out.println("Part 2:");
        System.out.println();
        Toolbox toolbox = new Toolbox();
        Integer numberToGuess = toolbox.getRandomInteger(10);
        Integer guessedNumber = toolbox.readIntegerFromCmd();
        if(guessedNumber == numberToGuess){
            System.out.println("You win");
        }
        else{
            System.out.println("Try again");
        }

        System.out.println("Part 3:");
        System.out.println();
        for(Integer i = new Integer(1); i < 61; i ++){
            if(i % 3 == 0){
                System.out.print("Fizz");
            }
            if(i % 5 == 0){
                System.out.print("Buzz");
            }
            if(i % 3 != 0 && i % 5 != 0){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
