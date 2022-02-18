package People;

import Things.LunCrystal;

public class Fuchsia extends Human {

    public Fuchsia(String name) {
        super(name);
    }

    public void chekLuneCrustal(LunCrystal lunCrystal) {
        System.out.println("Фуксия: велчина зоны " + lunCrystal.getName() + " зависит от величины кристалла и направлена на манер светового луча");
    }
}
