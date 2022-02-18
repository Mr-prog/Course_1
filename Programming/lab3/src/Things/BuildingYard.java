package Things;

public class BuildingYard {
    int percentOfWood;
    boolean weightlessness;

    public BuildingYard(int percentOfWood, boolean weightlessness) {
        this.percentOfWood = percentOfWood;
        this.weightlessness = weightlessness;
    }

    public void putWood(double size) {
        percentOfWood += (int) ((int) size * 1.5);
    }

    public boolean getPercentOfWoodState() {
        return percentOfWood >= 100;
    }

    public int getPercentOfWood() {
        return percentOfWood;
    }
}
