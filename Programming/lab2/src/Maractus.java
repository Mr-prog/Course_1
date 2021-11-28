import ru.ifmo.se.pokemon.*;

public class Maractus extends Pokemon {
    Maractus(String name, int level) {
        super(name, level);
        addType(Type.GRASS);
        setStats(75, 86, 67, 60, 106, 67);
        setMove(new IceBeam(), new ShadowBall(), new X_Scissor(), new IceShard());
    }
}

class ShadowBall extends SpecialMove {
    ShadowBall() {
        super(Type.GHOST, 80.0, 1.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect LowArmor = new Effect().chance(0.2).turns(1).stat(Stat.DEFENSE, -1);
        p.setCondition(LowArmor);
    }

    protected String describe() {
        return ("Использует Shadow Ball");
    }
}

class IceBeam extends SpecialMove {
    IceBeam() {
        super(Type.ICE, 90.0, 1.0);
    }

    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) Effect.freeze(p);
    }

    protected String describe() {
        return ("Использует Ice Beam");
    }
}

class X_Scissor extends PhysicalMove {
    X_Scissor() {
        super(Type.BUG, 80.0, 1.0);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }

    protected String describe() {
        return ("Использует X-Scissor");
    }
}

class IceShard extends PhysicalMove {
    IceShard() {
        super(Type.ICE, 40.0, 1.0);
    }

    protected void applyOppDamage(Pokemon def, double damage) {
        def.setMod(Stat.HP, (int) Math.round(damage));
    }

    protected String describe() {
        return ("Использует Ice Shard");
    }
}

