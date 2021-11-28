import ru.ifmo.se.pokemon.*;

public class Seadra extends Horsea {
    Seadra(String name, int level) {
        super(name, level);
        addType(Type.WATER);
        setStats(55, 65, 95, 85, 95, 45);
        setMove(new AquaTail());
    }
}

class AquaTail extends PhysicalMove {
    AquaTail() {
        super(Type.WATER, 90, 0.9);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }

    protected String describe() {
        return ("Использует Aqua Tail");
    }
}
