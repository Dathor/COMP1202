public class Bombe {

    public char[] findPlugs(EnigmaMachine em, String containedMessage, char firstPlug, char secondPlug, String message) throws Exception{
        String decodedMessage = new String();
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                em.addPlug(firstPlug, (char) (i + 65));
                em.addPlug(secondPlug, (char) (j + 65));
                for(int k = 0; k < message.length(); k++){
                    decodedMessage = new StringBuilder(decodedMessage).insert(decodedMessage.length(), em.encodeLetter(message.charAt(k))).toString();
                }
                if(decodedMessage.contains(containedMessage)){
                    return new char[]{(char) (i + 65), (char) (j + 65)};
                }
                decodedMessage = new String();
            }
            em.clearPlugboard();
        }
        throw new Exception("Couldn't find the plugs");
    }
}
