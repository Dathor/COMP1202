import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //Creates 3 animals
        Wolf wolf = new Wolf(5, "Gosho");
        Cow cow = new Cow(4, "Milka");

        System.out.println("Part 1:");


        Meat meat = new Meat("meat");
        Plant plant = new Plant("grass");

        try{
            cow.eat(plant, 3);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        try{
            wolf.eat(meat, 2);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }

        System.out.println("Part 2:");

        wolf = new Wolf();

        System.out.println(wolf.getName() + " " + wolf.getAge());

        System.out.println("Part 3:");

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Wolf(3,"Name1"));
        animals.add(new Parrot(2,"Name2"));
        animals.add(new Parrot(4,"Name3"));
        animals.add(new Wolf(7,"Name4"));
        animals.add(new Parrot(2,"Name5"));
        animals.add(new Wolf(6,"Name6"));
        animals.add(new Wolf(1,"Name7"));

        Collections.sort(animals);

        for(Animal animal: animals){
            System.out.println(animal.getName() + " " + animal.getAge());
        }

    }
}
