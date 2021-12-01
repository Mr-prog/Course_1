public abstract class Human {
    private String name;
    private Temper temper;
    private Talent talent;

    Human(Talent talent, Temper temper) {
        this.temper = temper;
        this.talent = talent;
    }

    Human(String name, Talent talent, Temper temper) {
        this(talent, temper);
        this.name = name;
    }

    public Temper getTemper() {
        return temper;
    }

    public Talent getTalent() {
        return talent;
    }
}
