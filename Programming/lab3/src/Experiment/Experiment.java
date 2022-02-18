package Experiment;

import Mechanism.Condition;
import Mechanism.WeightlessnessDevice;
import People.*;
import Things.*;

import java.util.Objects;


public class Experiment implements ContinuaAble {
    private final Fuchsia fuchsia;
    private final LunCrystal lunCrystal;
    private final Znayka znayka;
    private final Seledochka seledochka;
    private final AntiluniteCrystal crystal;
    private final Item item;

    public Experiment(Znayka znayka, Seledochka seledochka, AntiluniteCrystal crystal, Item item, Fuchsia fuchsia, LunCrystal lunCrystal) {
        this.znayka = znayka;
        this.seledochka = seledochka;
        this.crystal = crystal;
        this.item = item;
        this.lunCrystal = lunCrystal;
        this.fuchsia = fuchsia;
    }


    public void go(Scientist scientist) {

        WeightlessnessDevice weightlessnessDevice = new WeightlessnessDevice("Прибор невесомости", Condition.FIT);
        weightlessnessDevice.putItem(lunCrystal);
        fuchsia.chekLuneCrustal(lunCrystal);


        GetTemper getTemperZN = znayka::getTemper;
        GetTemper getTemperSL = seledochka::getTemper;
        if (scientist.getTalent() != Talent.SILLY) {
            boolean zn = scientist.closeExperimentalProgram(getTemperZN.temper(), znayka.getTalent());
            boolean sel = scientist.closeExperimentalProgram(getTemperSL.temper(), seledochka.getTalent());
            if (zn & sel) {
                checkContinuaAble(true);
            } else {
                if (!zn) {
                    System.out.println("Ученые распознали хитрый план Знайки");
                    checkContinuaAble(false);
                } else {
                    System.out.println("Ученые распознали хитрый план Селедочки");
                }
                checkContinuaAble(false);
            }
        }

        System.out.println("Проверка антилунита на подлинность:");
        try {
            if (((Object) item).equals(crystal) || crystal.hashCode() == item.hashCode()) {
                System.out.println("Антилунит оказался обычной подделкой, эксперимент завершен");
                System.exit(0);
            } else {
                System.out.println("Кристалл действительно обладает уникальными свойствами антилунита");
            }
            System.out.println("Селедочка начал свой эксперимент");
            if (seledochka.getTalent() != Talent.SILLY) {
                double dist = seledochka.calculateDist(item.getCoordinateX(), item.getCoordinateY(), crystal.getCoordinateX(), crystal.getCoordinateY());
                double energy = seledochka.calculateEnergy(crystal.getSize());
                System.out.println("Селедочка посчитал дистанцию между антилунитом и обьектом: " + dist + " Энергия антилунита: " + energy);
                seledochka.makeConclusion(energy, dist, item.getName());
            } else {
                System.out.println("Cеледочка оказался слишком глуп, для проведения эксперемента");
            }
            if (seledochka.getTemper() == Temper.EVIL) {
                System.out.println("Селедочка внял силу антилунита и в будущем захочет стать его единственным обладателем");
            }
            System.out.println("Знайка начал свой эксперимент");
            if (znayka.getTalent() != Talent.SILLY) {
                double dist = znayka.calculateDist(item.getCoordinateX(), item.getCoordinateY(), crystal.getCoordinateX(), crystal.getCoordinateY());
                double energy = znayka.calculateEnergy(crystal.getSize());
                System.out.println("Знайка посчитал дистанцию между антилунитом и обьектом: " + dist + " Энергия антилунита: " + energy);
                znayka.makeConclusion(energy, dist, item.getName());
            } else {
                System.out.println("Знайка оказался слишком глуп, для проведения эксперемента");
            }
            if (znayka.getTemper() == Temper.EVIL) {
                System.out.println("Знайка убедился в силе антилунита и планирует использовать его в качестве оружия");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Мы вынуждены остановить проверку!!!");
            e.printStackTrace();
        }
    }

    @Override
    public void checkContinuaAble(boolean var1) {

        if (var1) {
            System.out.println("Ученые одобрили эксперимент друзей");
        } else {
            System.out.println("Ученые предпочли держать секреты антилунита в тайне");
            System.exit(0);
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(crystal, item);
    }


    public LunCrystal getLunCrystal() {
        return lunCrystal;
    }
}
