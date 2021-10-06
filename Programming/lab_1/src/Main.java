import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner message = new Scanner(System.in);
        System.out.print("Введите сообщение: ");
        int num = message.nextInt();
        int[] mess = toArr(num);
        decoding(mess);

    }

    public static  int[] toArr(int num){ // Converting an integer to an array
        int [] arr = new int[7];
        int k = 6;
        while(num > 0){
            arr[k] = num % 10;
            num /= 10;
            k--;
        }
        return arr;
    }
        
    public static void decoding(int[] mess){

        int[] arr = new int[7];
        int k = 0;
        for(int i = 0; i < mess.length; i++){ // Making an array with key numbers equal zero to check them for errors
            int key_num = (int) Math.pow(2, k) - 1;
            if(i == key_num){
                arr[i] = 0;
                k++;
            }
            else{
                arr[i] = mess[i];
            }
        }

        k = 0;
        for(int i = 0; i < arr.length; i++){
            int key_num = (int) Math.pow(2, k);
            if(i == key_num - 1){
                int sum = 0;
                for(int j = i; j < arr.length; j+=(2 * key_num)){
                    for(int l = j; l < j + key_num; l ++){
                        sum += arr[l];
                    }
                }
                arr[i] = sum % 2; // Filling the key numbers with the right values
                k++;
            }
        }

        int err = 0;
        for(int i = 0; i < arr.length; i++){ // Comparing the correct message with received message to find the error
            if(arr[i] != mess[i]){
                err += (i + 1);
            }
        }
        if(err > 0){
            System.out.print("В сообщении присутсвует ошибка. Правильное сообщение: ");
            mess[err - 1] = (mess[err - 1] == 0)? 1 : 0;
            for(int i : mess){
                System.out.print(i);
            }
        }
        else{
            System.out.print("В сообщении ошибок не обнаружено.");
        }
    }
}
//public class Main {
//
//    public static void main(String[] args) {
//        long[] a = firstTask();
//        double[] x = secondTask();
//        double[][] e = thirdTask(a, x);
//        printArray(e);
//    }
//
//    public static long[] firstTask(){
//        long[] a = new long[15];
//        for (int i = 0; i < a.length; i++){
//            a[i] = 5 + i;
//        }
//        return a;
//    }
//
//
//    public static double[] secondTask(){
//        double[] x = new double[18];
//        float max = 13;
//        float min = -11;
//        for (int i = 0; i < x.length; i++) {
//            x[i] = (Math.random()*((max - min) + 1)) + min;
//        }
//
//        return x;
//    }
//    public static double[][] thirdTask(long[] a, double[] b){
//        double[][] e = new double[15][18];
//        long[] cond_one = {6, 7, 9, 13, 14, 16, 19};
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                double x = b[j];
//                long c = a[i];
//                if (a[i] == 5){
//                    e[i][j] = Math.cbrt(Math.asin(Math.exp(-(Math.abs(x)))));
//
//                }
//                else if(firstCond(cond_one, c)){
//                    e[i][j] = Math.pow(Math.pow(Math.atan((x+1)/24), (Math.tan(x) - 1) / Math.sin(x)), 2);
//                }
//                else {
//                    e[i][j] = Math.log((Math.pow(Math.cos(x), 2))/2 * Math.PI);
//                }
//            }
//
//        }
//        return e;
//    }
//    public static void printArray(double[][] e){
//        for (double[] doubles : e) {
//            for (int j = 0; j < e[0].length; j++) {
//                System.out.printf("%-8.3f", doubles[j]);
//                System.out.print("\t");
//            }
//            System.out.println();
//        }
//    }
//    public static boolean firstCond(long a[], long b){
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == b){
//                return true;
//            }
//        }
//        return false;
//    }
//}
