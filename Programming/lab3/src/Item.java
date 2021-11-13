public abstract class Item {
    protected Object DataTime;
    private double weight;
    private int distance;
    private int worldTime;
    public Item(double weight, int distance, int worldTime){
        this.weight = weight;
        this.distance = distance;
        this.worldTime = worldTime;
    }
    public int getWorldTime() {
        return worldTime;
    }

    public void setWorldTime(int worldTime) {
        this.worldTime = worldTime;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }

}
