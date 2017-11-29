import java.util.*;

public class Main {

    public static void main(String[] args) {

        EnigmaMachine em = new EnigmaMachine();

//        EnigmaFile ef = new EnigmaFile();

        //em.start();

//        ef.decodeFile("test.txt", "textDecoded.txt");

//        em.addRotor(new BasicRotor("IV"), 0);
//        em.setPosition(0, 8);
//
//        em.addRotor(new BasicRotor("III"), 1);
//        em.setPosition(1, 4);
//
//        em.addRotor(new BasicRotor("II"), 2);
//        em.setPosition(2, 21);
//
//        em.addReflector(new Reflector("ReflectorI"));

//        em.addPlug('H', 'L');
//        em.addPlug('G', 'P');
//
//        em.addRotor(new BasicRotor("V"), 0);
//        em.addRotor(new BasicRotor("III"), 1);
//        em.addRotor(new BasicRotor("II"), 2);
//
//        em.addReflector(new Reflector("ReflectorI"));

        em.addPlug('M', 'F');
        em.addPlug('O', 'I');

        em.addReflector(new Reflector("ReflectorI"));

        Bombe bombe = new Bombe();

//        try{
//            HashMap<String, Character[]> answer = bombe.findPlugs(em, "ANSWER", 'D', 'S', "JBZAQVEBRPEVPUOBXFLCPJQSYFJI");
//            Set<String> messages = answer.keySet();
//            Iterator<String> it = messages.iterator();
//            while(it.hasNext()){
//                String current = it.next();
//                System.out.println(current + " : " + answer.get(current)[0] + " " + answer.get(current)[1]);
//            }
//        } catch (Exception e){
//            System.err.println(e.getMessage());
//        }

//        try{
//            HashMap<String, Integer[]> answer = bombe.findRotorPositions(em, "ELECTRIC", "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD");
//            Set<String> messages = answer.keySet();
//            Iterator<String> it = messages.iterator();
//            while(it.hasNext()){
//                String current = it.next();
//                System.out.println(current + " : " + answer.get(current)[0] + " " + answer.get(current)[1] + " " + answer.get(current)[2]);
//            }
//        } catch (Exception e){
//            System.err.println(e.getMessage());
//        }

        try{
            HashMap<String, String[]> answer = bombe.findRotorTypes(em, 22, 24, 23, "JAVA", "WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW");
            Set<String> messages = answer.keySet();
            Iterator<String> it = messages.iterator();
            while(it.hasNext()){
                String current = it.next();
                System.out.println(current + " : " + answer.get(current)[0] + " " + answer.get(current)[1] + " " + answer.get(current)[2]);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
