public class Item {

    private double coordinateX;
    private double coordinateY;
    private String name;
    public Item(double coordinateX, double coordinateY, String name) {

        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.name = name;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public String getName() {
        return name;
    }
}
