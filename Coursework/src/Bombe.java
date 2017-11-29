import java.util.HashMap;

public class Bombe {

    public HashMap<String, Character[]> findPlugs(EnigmaMachine em, String containedMessage, char firstPlug, char secondPlug, String message) throws Exception{
        HashMap<String, Character[]> plugs = new HashMap<>();
        String decodedMessage = new String();
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                em.addPlug(firstPlug, (char) (i + 65));
                em.addPlug(secondPlug, (char) (j + 65));

                for(int k = 0; k < message.length(); k++){
                    decodedMessage = new StringBuilder(decodedMessage).insert(decodedMessage.length(), em.encodeLetter(message.charAt(k))).toString();
                }

                if(decodedMessage.contains(containedMessage)){
                    plugs.put(decodedMessage, new Character[]{ (char) (i + 65), (char) (j + 65)});
                }

                decodedMessage = new String();
            }
            em.clearPlugboard();
        }
        if(!plugs.isEmpty()){
            return plugs;
        }
        throw new Exception("Couldn't find the plugs");
    }

    public HashMap<String, Integer[]> findRotorPositions(EnigmaMachine em, String containedMessage, String message) throws Exception{
        HashMap<String, Integer[]> rotors = new HashMap<>();
        String decodedMessage = new String();

        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                for(int k = 0; k < 26; k++){
                    em.setPosition(0, i);
                    em.setPosition(1, j);
                    em.setPosition(2, k);

                    for(char current: message.toCharArray()){
                        decodedMessage = new StringBuilder(decodedMessage).insert(decodedMessage.length(), em.encodeLetter(current)).toString();
                    }

                    if(decodedMessage.contains(containedMessage)){
                        rotors.put(decodedMessage, new Integer[]{i, j, k});
                    }

                    decodedMessage = new String();
                }
            }
        }
        if(!rotors.isEmpty()){
            return rotors;
        }
        throw new Exception("Couldn't find the rotor positions");
    }

    public HashMap<String, String[]> findRotorTypes(EnigmaMachine em, int firstPosition, int secondPosition, int thirdPosition, String containedMessage, String message) throws Exception{
        HashMap<String, String[]> rotors = new HashMap<>();
        String decodedMessage = new String();

        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5; j++){
                for(int k = 1; k <= 5; k++){
                    em.addRotor(new BasicRotor(this.intToRoman(i)), 0);
                    em.addRotor(new BasicRotor(this.intToRoman(j)), 1);
                    em.addRotor(new BasicRotor(this.intToRoman(k)), 2);

                    em.setPosition(0, firstPosition);
                    em.setPosition(1, secondPosition);
                    em.setPosition(2, thirdPosition);

                    for(char current: message.toCharArray()){
                        decodedMessage = new StringBuilder(decodedMessage).insert(decodedMessage.length(), em.encodeLetter(current)).toString();
                    }

                    if(decodedMessage.contains(containedMessage)){
                        rotors.put(decodedMessage, new String[]{this.intToRoman(i), this.intToRoman(j), this.intToRoman(k)});
                    }

                    decodedMessage = new String();
                }
            }
        }
        if(!rotors.isEmpty()){
            return rotors;
        }

        throw new Exception("Couldn't find the rotor types");
    }

    private String intToRoman(int number){
        String roman;
        switch (number){
            case 1:
                roman = "I";
                break;
            case 2:
                roman = "II";
                break;
            case 3:
                roman = "III";
                break;
            case 4:
                roman = "IV";
                break;
            case 5:
                roman = "V";
                break;
            default:
                roman = null;
                break;
        }
        return roman;
    }
}
