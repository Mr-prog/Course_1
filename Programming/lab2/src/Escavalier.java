import ru.ifmo.se.pokemon.*;

public class Escavalier extends Pokemon {
    Escavalier(String name, int level){
        super(name, level);
        addType(Type.BUG);
        setStats(70, 135, 105, 20, 60, 105);
        setMove(new NastyPlot(), new ShadowBall(), new Swagger(), new ZenHeadbutt());
    }
}

class ZenHeadbutt extends PhysicalMove{
    ZenHeadbutt(){
        super(Type.PSYCHIC, 80, 0.9);
    }
    protected void applyOppEffects(Pokemon p){
        if(Math.random() < 0.2) Effect.flinch(p);
    }
    protected String describe() {
        return ("Использует Zen Headbutt");
    }
}
