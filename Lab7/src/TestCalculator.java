public class TestCalculator {

    /**
     * Tests the string parser function
     * @return True if the parser works
     */
    public boolean testParser(){
        Calculator calc = new Calculator();
        boolean works = true;

        if(calc.x("12 + 5") == 17){
            System.out.println("[ OK ] Parser adds correctly.");
        } else{
            System.out.println("[FAIL] Basic parsing fails to add.");
            works = false;
        }

        if(calc.x("12 x 5") == 60){
            System.out.println("[ OK ] Parser multiplies correctly.");
        } else {
            System.out.println("[FAIL] Basic parsing fails to multiply.");
            works = false;
        }

        if(calc.x("12 [ 3") == null){
            System.out.println("[ OK ] Parser returns null for operators which are not supported.");
        } else {
            System.out.println("[FAIL] Parser does not return null for operators which are not supported.");
            works = false;
        }

        return works;
    }

    /**
     * Tests the addition function
     * @return True if addition works
     */
    public boolean testAdd(){
        Calculator calc = new Calculator();
        calc.x = 2.0;
        boolean works = true;

        if(calc.x(new Double(5)) == 7){
            System.out.println("[ OK ] Calculator can add positive numbers");
        } else {
            System.out.println("[FAIL] Calculator adds incorrectly");
            works = false;
        }

        if(calc.x(new Double(-2)) == 0){
            System.out.println("[ OK ] Calculator can add a negative number");
        } else{
            System.out.println("[FAIL] Calculator adds with negative numbers incorrectly");
            works = false;
        }

        return works;
    }

    /**
     * Tests the multiplication function
     * @return True if multiplication works
     */
    public boolean testMultiplication(){
        Calculator calc = new Calculator();
        calc.x = 2.0;
        boolean works = true;

        if(calc.x(5) == 10){
            System.out.println("[ OK ] Calculator can multiply positive numbers");
        } else{
            System.out.println("[FAIL] Calculator multiplies incorrectly");
            works = false;
        }

        if(calc.x(-2) == -4){
            System.out.println("[ OK ] Calculator can multiply by a negative number");
        } else{
            System.out.println("[FAIL] Calculator multiplies by negative incorrectly");
            works = false;
        }

        return works;
    }

}
