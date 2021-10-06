
public class Main {

    public static void main(String[] args) {
        long[] a = firstTask();
        double[] x = secondTask();
        double[][] e = thirdTask(a, x);
        printArray(e);
    }

    public static long[] firstTask(){
        long[] a = new long[15];
        for (int i = 0; i < a.length; i++){
            a[i] = 5 + i;
        }
        return a;
    }


    public static double[] secondTask(){
        double[] x = new double[18];
        float max = 13;
        float min = -11;
        for (int i = 0; i < x.length; i++) {
            x[i] = (Math.random()*((max - min) + 1)) + min;
        }

        return x;
    }
    public static double[][] thirdTask(long[] a, double[] b){
        double[][] e = new double[15][18];
        long[] cond_one = {6, 7, 9, 13, 14, 16, 19};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                double x = b[j];
                long c = a[i];
                if (a[i] == 5){
                    e[i][j] = Math.cbrt(Math.asin(Math.exp(-(Math.abs(x)))));

                }
                else if(firstCond(cond_one, c)){
                    e[i][j] = Math.pow(Math.pow(Math.atan((x+1)/24), (Math.tan(x) - 1) / Math.sin(x)), 2);
                }
                else {
                    e[i][j] = Math.log((Math.pow(Math.cos(x), 2))/2 * Math.PI);
                }
            }

        }
        return e;
    }
    public static void printArray(double[][] e){
        for (double[] doubles : e) {
            for (int j = 0; j < e[0].length; j++) {
                System.out.printf("%-8.3f", doubles[j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static boolean firstCond(long a[], long b){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b){
                return true;
            }
        }
        return false;
    }
}
