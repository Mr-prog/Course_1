package People;

public class Kubic extends Human {
    public Kubic(String name) {
        super(name);
    }

    public boolean startBuild() {
        System.out.println(getName() + ": начать строительство");
        return true;
    }
}
