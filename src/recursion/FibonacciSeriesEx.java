package recursion;

public class FibonacciSeriesEx {

    public static void main(String[] args) {
        int a=6;
        System.out.println(getFibonacciSeries(a));
    }

    private static int getFibonacciSeries(int a) {
        if (a==0){
           // System.out.println(0);
            return 0;
        } else if (a<2){
            //System.out.println(1);
            return 1;
        }else {
            int num=getFibonacciSeries(a-1)+getFibonacciSeries(a-2);
            System.out.println(num);
            return num;
        }
    }
}
