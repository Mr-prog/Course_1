import ru.ifmo.se.pokemon.*;

public class Kingdra extends Seadra{
    Kingdra(String name, int level){
        super(name, level);
        addType(Type.DRAGON);
        setStats(75, 95, 95, 85, 95, 95);
        setMove(new FocusEnergy());
    }
}

class FocusEnergy extends StatusMove{
    FocusEnergy(){
        super(Type.NORMAL, 0.0, 0.0);
    }
    protected void applySelfEffects(Pokemon p) {
        Effect UpCritical = new Effect().stat(Stat.SPEED, 1);
        p.setCondition(UpCritical);
    }
    protected String describe() {
        return ("Использует Focus Energy");
    }
}