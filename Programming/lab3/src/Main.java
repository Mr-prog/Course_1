import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Znayka znayka = new Znayka(Talent.GENIUS, Temper.RIGHT);
        Seledochka seledochka = new Seledochka(Talent.GENIUS, Temper.RIGHT);
        Scientist scientist = new Scientist("Mark", Talent.SILLY, Temper.FINE);
        Item item = new Item(100.0, 100.0, "Камень");
        AntiluniteCrystal ant = new AntiluniteCrystal(2.0, 90.0, 90.0);
        Experiment ex1 = new Experiment(znayka, seledochka, ant, item);
        ex1.go(scientist);



    }
}


