package Things;

public class AntiluniteCrystal extends Materials {
    private double size;
    private double coordinateX;
    private double coordinateY;

    public AntiluniteCrystal(double size, double coordinateX, double coordinateY, String name) {
        super(size, name);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }


    public double getSize() {
        return size;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
