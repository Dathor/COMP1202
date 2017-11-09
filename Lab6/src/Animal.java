public abstract class Animal {
    private Integer age;
    private  String name;

    public Animal(Integer age, String name){
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public abstract void makeNoise();

    public abstract void eat(Food food) throws Exception;
}
