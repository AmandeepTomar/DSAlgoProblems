package dynamicproblems;

public class FinbinnachiDpProblem {

    public static void main(String[] args) {
        int n = 10;
        int finN = normalFib(n);
        System.out.println("Normal fib "+finN);
        int finM = fibMonetization(n,new int[n+1]);
        System.out.println("fibMonetization "+finM);
    }

    private static int normalFib(int n) {
        if(n==0 || n==1) return n;

        System.out.println("Print N "+n);
        int fin1 = normalFib(n-1);
        int fib2 = normalFib(n-2);
        int fin3 = fin1+fib2;
        return fin3;
    }

    private static int fibMonetization(int n , int qb[]){
        if (n==0 || n==1){
            return  1;
        }

        if(qb[n]!=0){
            return  qb[n];
        }
        System.out.println("Print N "+n);
        int fib1 = fibMonetization(n-1,qb);
        int fib2 = fibMonetization(n-2,qb);
        int fib3 = fib1+fib2;

        qb[n]=fib3;
        return  fib3;
    }
}
