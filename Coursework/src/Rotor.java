public abstract class Rotor {

    protected String name;
    protected int position;
    protected int[] mapping;
    protected static final int ROTORSIZE = 25;

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public abstract void initialise(String name);

    public abstract int substitute(int character);

}
