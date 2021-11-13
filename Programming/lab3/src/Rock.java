public class Rock extends Item {
    enum DataTime{
        Morning,
        Afternoon,
        Night
    }
    public Rock(double weight, int distance, int worldTime){
        super(weight, distance, worldTime);
    }
    public void on(){
        System.out.println(getDistance());
    }
}
