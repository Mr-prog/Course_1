import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Maractus("Сасават", 1);
        Pokemon p2 = new Karrablast("Усков", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}
