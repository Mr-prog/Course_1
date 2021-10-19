import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Maractus("Кактус", 1);
        Pokemon p2 = new Karrablast("Броневик", 1);
        Pokemon p3 = new Escavalier("Рыцарь", 1);
        Pokemon p4 = new Horsea("Дракончик", 1);
        Pokemon p5 = new Seadra("Дракон", 2);
        Pokemon p6 = new Kingdra("Король драконов", 3);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
