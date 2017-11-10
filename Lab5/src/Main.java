import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args){
        //Create the word groups
        WordGroup plato = new WordGroup("You can discover more about a person in an hour of play than in a year of conversation");
        WordGroup roosevelt = new WordGroup("When you play play hard when you work dont play at all");

        //Create the word arrays
        String[] platoArray = plato.getWordArray();
        String[] rooseveltArray = roosevelt.getWordArray();

        //Print out the arrays
        for(int i = 0; i < platoArray.length; i++){
            System.out.print(platoArray[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < rooseveltArray.length; i++){
            System.out.print(rooseveltArray[i] + " ");
        }

        System.out.println();

        //Get the combined word set and print it
        HashSet<String> combinedSet = plato.getWordSet(roosevelt);

        for(String word: combinedSet){
            System.out.print(word + " ");
        }

        System.out.println();

        //Get the hash maps of the words and their amounts and print them
        HashMap<String, Integer> platoCounts = plato.getWordCounts();
        HashMap<String, Integer> rooseveltCounts = roosevelt.getWordCounts();

        for(String key:platoCounts.keySet()){
            System.out.println(key + " : " + platoCounts.get(key));
        }

        for(String key:rooseveltCounts.keySet()){
            System.out.println(key + " : " + rooseveltCounts.get(key));
        }

    }
}