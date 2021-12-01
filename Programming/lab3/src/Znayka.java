public class Znayka extends Human implements Describe {
    private static String name;
    static {
        name = "Znayka";
    }

    Znayka(Talent talent, Temper temper) {
        super(talent, temper);
    }

    @Override
    public void makeConclusion(double energy, double distance, String name) {
        if (energy > distance) {
            System.out.println("Знайка: Мой будущий прибор способен поднять " + name);
        }
        else {
            System.out.println("Знайка: Мой будущий прибор не способен поднять " + name);
        }
    }

    public double calculateEnergy(double size) {
        if (Math.random() < 0.3){
            System.out.println("Знайка был не самым прилежным учеником и рассчет энергии антилунита оказался непростой задачей");
        }
        double energy = size * Math.PI;
        return energy;
    }

    public double calculateDist(double var1, double var2, double var3, double var4) {
        if(Math.random() < 0.5){
            System.out.println("Незнайке пришлось серьезно задуматься о расстоянии между обьектами");
        }
        double distance = Math.sqrt(Math.pow(var1 - var3, 2) + Math.pow(var2 - var4, 2));
        return distance;
    }
}
