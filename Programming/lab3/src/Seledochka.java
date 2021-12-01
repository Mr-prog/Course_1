public class Seledochka extends Human implements Describe {
    private static String name;

    static {
        name = "Seledochka";
    }

    Seledochka(Talent talent, Temper temper) {
        super(talent, temper);
    }

    @Override
    public void makeConclusion(double energy, double distance, String name) {
        if (energy > distance) {
            System.out.println("Селедочка: Энергии выделяемой антилунитом достаточно для левитации предмета: " + name);
        } else {
            System.out.println("Селедочка: Энергии выделяемой антилунитом не достаточно для левитации предмета: " + name);
        }
    }

    public double calculateEnergy(double size) {
        if (Math.random() < 0.4) {
            System.out.println("Селедочка в замешательстве над правильностью своих формул");
            if (getTalent() != Talent.GENIUS) {
                System.out.println("К сожалению Селедочка ошибся в своих суждениях, так как оказался не столь умен");
                return Math.random() * 100;
            }
        }
        double energy = size * Math.PI;
        return energy;
    }

    public double calculateDist(double var1, double var2, double var3, double var4) {
        if (Math.random() < 0.3){
            System.out.println("Селедочка с детсва умел обращаться с измерительными приборами");
        }
        double distance = Math.sqrt(Math.pow(var1 - var3, 2) + Math.pow(var2 - var4, 2));
        return distance;
    }
}
