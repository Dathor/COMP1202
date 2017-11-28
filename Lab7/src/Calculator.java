public class Calculator {

     Double x;
    /*
    * Chops up input on ' ' then decides whether to add or multiply.
    * If the string does not contain a valid format returns null.
    */
    public Double x(String x){
        String[] splitEquation = x.split(" ");

        this.x = Double.parseDouble(splitEquation[0]);

        if(splitEquation[1].equals("+")){
            return this.x((Double) Double.parseDouble(splitEquation[2]));
        }
        if(splitEquation[1].equals("x")){
            return this.x(Double.parseDouble(splitEquation[2]));
        }

        return null;
    }

    /*
    * Adds the parameter x to the instance variable x and returns the answer as a Double.
    */
    public Double x(Double x){
        System.out.println("== Adding ==");
        return new Double(this.x + x);
    }

    /*
    * Multiplies the parameter x by instance variable x and return the value as a Double.
    */
    public Double x(double x){
        System.out.println("== Multiplying ==");
        return new Double(this.x * x);
    }
}
