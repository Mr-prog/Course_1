public class AntiluniteCrystal{
    private double size;
    private double coordinateX;
    private double coordinateY;
    private double energy;
    public AntiluniteCrystal(double size, double coordinateX, double coordinateY) {
        this.size = size;
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

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
