public class Main {

    public static void main(String[] args) {

        EnigmaMachine em = new EnigmaMachine();

//        EnigmaFile ef = new EnigmaFile();

        //em.start();

//        ef.decodeFile("test.txt", "textDecoded.txt");

        em.addRotor(new BasicRotor("IV"), 0);
        em.setPosition(0, 8);

        em.addRotor(new BasicRotor("III"), 1);
        em.setPosition(1, 4);

        em.addRotor(new BasicRotor("II"), 2);
        em.setPosition(2, 21);

        em.addReflector(new Reflector("ReflectorI"));


        Bombe bombe = new Bombe();

        try{
            char[] answer = bombe.findPlugs(em, "ANSWER", 'D', 'S', "JBZAQVEBRPEVPUOBXFLCPJQSYFJI");
            for(int i = 0; i < 2; i++){
                System.out.println(answer[i]);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
