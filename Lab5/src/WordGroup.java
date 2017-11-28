import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.stream.Collectors;

public class WordGroup {

    private String words;

    /**
     * Creates a word group from a string and makes all of the letters lowercase
     * @param input The string to be processed
     */
    public WordGroup(String input){
        words = input.toLowerCase();
    }

    /**
     * Splits the string into an array of strings for every word
     * @return The array of strings
     */
    public String[] getWordArray(){
        return words.split(" ");
    }


    /**
     * Combines the words from the word group and the words from another group into a hash set
     * @param group The second word group
     * @return The hash set of words
     */
    public HashSet<String> getWordSet(WordGroup group){
        HashSet<String> result = new HashSet<String>();

        String[] firstArray = this.getWordArray();
        String[] secondArray =  group.getWordArray();

        for(int i = 0; i < firstArray.length; i++){
            result.add(firstArray[i]);
        }
        for(int i = 0; i < secondArray.length; i++){
            result.add(secondArray[i]);
        }

        return result;
    }

    /**
     * Maps the words from the word group to the number of times each of them occur
     * @return The hash map of the words and the amount of times they occur
     */
    public HashMap<String, Integer> getWordCounts(){
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        String[] wordArray = this.getWordArray();

        for(String word: wordArray){
            result.put(word, result.getOrDefault(word, 0 ) + 1);
        }

        return result;
    }
}
