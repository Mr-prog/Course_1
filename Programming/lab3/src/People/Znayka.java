package People;


public class Znayka extends Human implements Describe {

    static {
        String name = "Znayka";
    }

    public Znayka(Talent talent, Temper temper) {
        super(talent, temper);
    }

    public boolean command(int percent) {
        if (percent >= 100) {
            System.out.println("Знайка велит прекратить работу на стройплощадке");
            return true;
        }
        System.out.println("Знайка велит продолжать работу");
        return false;
    }

    @Override
    public void makeConclusion(double energy, double distance, String name) {
        if (energy > distance) {
            System.out.println("Знайка: Мой будущий прибор способен поднять " + name);
        } else {
            System.out.println("Знайка: Мой будущий прибор не способен поднять " + name);
        }
    }

    public double calculateEnergy(double size) {
        if (Math.random() < 0.3) {
            System.out.println("Знайка был не самым прилежным учеником и рассчет энергии антилунита оказался непростой задачей");
        }
        return size * Math.PI;
    }

    public double calculateDist(double var1, double var2, double var3, double var4) throws InvalidParameterException {
        if (var1 <= var4) {
            throw new InvalidParameterException("Проверьте правильность введенных координат: " +
                    "\nПараметр var1 = " + var1 + " \nПараметр var4 = " + var4);
        }
        if (Math.random() < 0.5) {
            System.out.println("Незнайке пришлось серьезно задуматься о расстоянии между обьектами");
        }
        return (Math.sqrt(Math.pow(var1 - var3, 2) + Math.pow(var2 - var4, 2))) / (var1 - var4);
    }

    @Override
    public Temper getTemper() {
        return super.getTemper();
    }


}
