package Mechanism;

public class WeightlessnessDevice extends Mechanisms {
    Object item;

    public WeightlessnessDevice(String name, Condition condition) {
        super(name, condition);
    }

    public void putItem(Object item) {
        this.item = item;
    }

}
