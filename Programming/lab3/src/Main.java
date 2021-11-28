import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArraySorter test1 = new ArraySorter(System.currentTimeMillis());
        test1.createArr(5);
        test1.time();
        Claz claz = null;
        claz.methos();
        SUKA suka = SUKA.createSUKA();
        suka.SASAVAT();
        boolean result = 2 > 3;
        System.out.println(result);
        for (int i = 0; i < 10; i++) {
            System.out.print(i++);
        }
    }
}


class SUKA{
    static SUKA createSUKA(){
        return new SUKA();
    }
    private SUKA(){
    }
    public void SASAVAT() {
        System.out.println("SSS");
    }
}

class Claz{
    public static void methos(){
        System.out.println("Пишов нахуй");
    }
    public void sASAVAT() {
        System.out.println("SASAVAT");
    }
}
class ArraySorter {
    long startTime;
    int[] arr1;

    ArraySorter(long startTime) {
        this.startTime = startTime;
    }

    public void createArr(int size) {
        arr1 = new int[size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) Math.round(Math.random() * 100);
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int min = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = min;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    public void time() {
        System.out.println(System.currentTimeMillis() - startTime);
    }
}