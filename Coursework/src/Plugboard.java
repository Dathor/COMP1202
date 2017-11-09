import java.util.ArrayList;

public class Plugboard {

    private ArrayList<Plug> plugs;

    public Plugboard(){
        plugs = new ArrayList<Plug>();
    }

    public boolean addPlug(char end1, char end2){
        Plug newPlug = new Plug(end1, end2);
        for(Plug plug: plugs){
            if(plug.clashesWith(newPlug)){
                return false;
            }
        }
        plugs.add(newPlug);
        return true;
    }

    public int getNumPlugs(){
        return plugs.size();
    }

    public void clear(){
        plugs = new ArrayList<Plug>();
    }

    public char substitute(char input){
        for(Plug plug: plugs){
            if(input == plug.getEnd1()){
                return plug.getEnd2();
            }
            if(input == plug.getEnd2()){
                return plug.getEnd1();
            }
        }
        return input;
    }
}
