public class Main {

    public static void main(String[] args) {
        Parrot parrot = new Parrot(3, "Pesho");
        Wolf wolf = new Wolf(5, "Gosho");
        Cow cow = new Cow(4, "Milka");

        System.out.println("Part 1:");

        System.out.println(parrot.getName());
        System.out.println(wolf.getAge());

        Meat meat = new Meat("meat");
        Plant plant = new Plant("grass");

        System.out.println("Part 2:");

        parrot.makeNoise();
        wolf.makeNoise();
        cow.makeNoise();

        System.out.println("Part 3:");

        try{
            cow.eat(meat);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        try{
            wolf.eat(plant);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        parrot.eat(plant);
        parrot.eat(meat);

    }
}
