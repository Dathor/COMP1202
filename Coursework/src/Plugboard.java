import java.util.ArrayList;

public class Plugboard {

    private ArrayList<Plug> plugs;

    /**
     * Creates a new plugboard
     */
    public Plugboard(){
        plugs = new ArrayList<>();
    }

    /**
     * Add a plug to the plugboard
     * @param end1 The first end
     * @param end2 The second end
     * @return True if the plug is added
     */
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

    /**
     * Gets the number of the plugs
     * @return The number of the plugs
     */
    public int getNumPlugs(){
        return plugs.size();
    }

    /**
     * Clears the plugboard
     */
    public void clear(){
        plugs = new ArrayList<>();
    }

    /**
     * Substitutes the character through the plugboar
     * @param input The character
     * @return The substituted character
     */
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
