package People;

public class Shorties extends Human {
    public Shorties(String name) {
        super(name);
    }

    public void startWork(boolean state) {
        if (state) {
            System.out.println(getName() + " начал работу");
        }
    }


}
