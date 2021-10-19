import ru.ifmo.se.pokemon.*;

public class Horsea extends Pokemon{
    Horsea(String name, int level){
        super(name, level);
        addType(Type.PSYCHIC);
        setStats(60, 45, 70, 55, 75, 85);
        setMove(new Scratch(), new Confide());
    }
}

class Scratch extends PhysicalMove{
    Scratch(){
        super(Type.NORMAL, 40, 1.0);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }

    protected String describe() {
        return ("Использует Scratch");
    }
}

class Confide extends StatusMove{
    Confide(){
        super(Type.NORMAL, 0, 1.0);
    }

    protected void applyOppEffects(Pokemon p) {
        Effect LowSpAt = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        p.setCondition(LowSpAt);
    }

    protected String describe() {
        return ("Использует Confide");
    }
}