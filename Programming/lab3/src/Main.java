import Experiment.Experiment;
import Mechanism.AllTerrainVehicle;
import Mechanism.AllTerrainVehicle.Wheels;
import Mechanism.Condition;
import Mechanism.WheelsSate;
import People.*;
import Things.*;


public class Main {


    public static void main(String[] args) {
        BuildingYard moon = new BuildingYard(0, true);
        Shorties shorties2 = new Shorties("Коротышка Прокопий");
        Shorties shorties1 = new Shorties("Коротышка Закадий");
        Fuchsia fuchsia = new Fuchsia("Фуксия");
        LunCrystal lunCrystal = new LunCrystal(2, "Лунит");
        Vintik vintik = new Vintik("Винтик");
        Shpuntik shpuntik = new Shpuntik("Шпунтик");
        Kubic kubic = new Kubic("Кубик");
        Znayka znayka = new Znayka(Talent.GENIUS, Temper.RIGHT);
        Seledochka seledochka = new Seledochka(Talent.GENIUS, Temper.RIGHT);
        Scientist scientist = new Scientist("Mark", Talent.SILLY, Temper.FINE);
        Item item = new Item(100.0, 100.0, "Камень", 2.0);
        AntiluniteCrystal ant = new AntiluniteCrystal(2.0, 100.0, 100.0, "Crystal");
        AllTerrainVehicle allTerrainVehicle = new AllTerrainVehicle("Вехдеход", Condition.FIT);
        shorties1.startWork(kubic.startBuild());
        shorties2.startWork(kubic.startBuild());
        allTerrainVehicle.wheels.changeWheels(WheelsSate.CHAINSAW);


        try {
            BuildMaterials logs = new BuildMaterials(-10, "бревна");
            BuildMaterials boards = new BuildMaterials(20, "доски");
            while (!moon.getPercentOfWoodState()) {
                moon.putWood(vintik.build(logs));
                moon.putWood(shpuntik.build(boards));
                znayka.command(moon.getPercentOfWood());
            }
        } catch (InvalidSizeException e) {
            e.printStackTrace();
        }

        allTerrainVehicle.addDevices("Стиральная машина", Condition.BROKEN);
        allTerrainVehicle.addDevices("Пылесос", Condition.FIT);
        allTerrainVehicle.addDevices("Центробежный насос", Condition.DAMAGED);


        Experiment ex1 = new Experiment(znayka, seledochka, ant, item, fuchsia, lunCrystal);
        ex1.go(scientist);

    }
}


