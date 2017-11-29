public class Main {

    public static int a;
    public int b = 3;

    public static void main(String[] args) {

        a = 5;

        System.out.println(a);
        System.out.println(Main.a);

        Main main = new Main();

        System.out.println(main.test());

        System.out.println(a);
        System.out.println(main.b);

    }

    public int test(){
        a++;
        b = 4;
        return a;
    }
}
