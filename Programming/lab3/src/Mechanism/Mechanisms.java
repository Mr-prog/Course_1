package Mechanism;

public abstract class Mechanisms {
    private final String name;
    private final Condition condition;

    Mechanisms(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public Condition getCondition() {
        return condition;
    }
}
