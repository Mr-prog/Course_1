package Things;

public abstract class Materials {
    private final double size;
    private final String name;

    protected Materials(double size, String name) {
        this.size = size;
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
