import ru.ifmo.se.pokemon.*;

public class Karrablast extends Pokemon{
    Karrablast(String name, int level){
        super(name, level);
        addType(Type.BUG);
        setStats(50, 75, 45, 60, 40, 45);
        setMove(new ShadowBall(), new NastyPlot(), new Swagger());
    }
}

class NastyPlot extends StatusMove{
    NastyPlot(){
        super(Type.DARK,0,1.0);
    }
    protected void applySelfEffects(Pokemon p) {
        Effect UpSpecial = new Effect();
        UpSpecial.stat(Stat.SPECIAL_ATTACK, +2);
    }
    protected String describe() {
        return ("Использует Nasty Plot");
    }
}

class Swagger extends StatusMove{
    Swagger(){
        super(Type.NORMAL,0,0.85);
    }
    protected void applySelfEffects(Pokemon p) {
        Effect UpAttack = new Effect();
        UpAttack.stat(Stat.ATTACK, +2);
    }
    protected String describe() {
        return ("Использует Swagger");
    }
}


