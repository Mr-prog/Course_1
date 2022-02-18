package Things;

public class Item extends Materials {
    final double coordinateX;
    final double coordinateY;


    public Item(double coordinateX, double coordinateY, String name, double size) {
        super(size, name);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }


    public boolean check() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
