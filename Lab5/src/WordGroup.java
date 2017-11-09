import java.util.HashSet;
import java.util.HashMap;

public class WordGroup {

    private String words;

    public WordGroup(String input){
        words = input.toLowerCase();
    }

    public String[] getWordArray(){
        return words.split(" ");
    }

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

    public HashMap<String, Integer> getWordCounts(){
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        String[] wordArray = this.getWordArray();

        for(int i = 0; i < wordArray.length; i++){
            String lastWord = wordArray[i];
            int count = 0;
            for(int j = i; j < wordArray.length; j++){
                if(wordArray[j].equals(lastWord) && !result.containsKey(wordArray[j])){
                    count++;
                }
            }
            if(count != 0){
                result.put(lastWord, count);
            }
        }

        return result;
    }
}
