public class Plug {

    private char end1;
    private char end2;

    public Plug(char end1, char end2){
        this.end1 = end1;
        this.end2 = end2;
    }

    public char getEnd1() {
        return end1;
    }

    public char getEnd2() {
        return end2;
    }

    public void setEnd1(char end1) {
        this.end1 = end1;
    }

    public void setEnd2(char end2) {
        this.end2 = end2;
    }

    public char encode(char letterIn){
        if(letterIn == end1){
            return end2;
        }
        if(letterIn == end2){
            return  end1;
        }

        return letterIn;
    }

    public boolean clashesWith(Plug plugin){
        if(end1 == plugin.getEnd1() || end2 == plugin.getEnd2()){
            return true;
        }
        return false;
    }
}
