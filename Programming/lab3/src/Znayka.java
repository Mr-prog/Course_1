public class Znayka extends Human{
    static String name;
    static {
        name = "znayka";
    }
    Znayka(double weight){
        super(weight);
    }
    public void printName(){
        System.out.println(name);
    }
}
