package newpractice.mathametics;

import java.util.Arrays;

public class PrimeNoProblem {

    public static void main(String[] args) {

        seiveOfEratoSthenes(20);
        System.out.println(calculateGCD(12, 16));
        System.out.println(calculateFastPower(2,1));
    }


    private static long calculateFastPower(long a , long b){
        long res = 1;
        long mod = 100000007;
        while (b>0){
            if ((b &1)!=0){
                res= (res*a%mod)%mod;
            }
            a = (a%mod*a%mod)%mod;
            b = b >> 1;
        }
        return res;
    }

    private static int calculateGCD(int a, int b) {
        if (b == 0) return a;
       return calculateGCD(b, a % b);
    }

    private static void seiveOfEratoSthenes(int num) {

        boolean[] isPrime = new boolean[num + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= num; i++) {
            for (int j = 2 * i; j < num; j += i) {
                System.out.println("j =" + j + " i=" + i);
                isPrime[j] = false;
            }
        }

        System.out.println(Arrays.toString(isPrime));
    }
}
