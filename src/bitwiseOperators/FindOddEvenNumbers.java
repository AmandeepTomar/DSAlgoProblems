package bitwiseOperators;

public class FindOddEvenNumbers {

    /**
     * can check the difference
     *
     * Number is even 10
     * 15
     * With
     * Number is even 10
     * 1
     * */

    public static void main(String[] args) {
        int num=10;
        long startTime=System.currentTimeMillis();
        System.out.println(findOddAndEvenNumbers(num));
        long timeTaken=System.currentTimeMillis() - startTime;
        System.out.println(timeTaken);

        long startTime1=System.currentTimeMillis();

        System.out.println(findOddEvenUsingBitOperator(num));
        long timeTaken1=System.currentTimeMillis() - startTime1;
        System.out.println(timeTaken1);
    }

    private static String findOddAndEvenNumbers(int n) {
        // % is operating on decimal, it converts decimal to binary and all so have more overhead
        if (n%2==0){
            return "Number is even "+n;
        }else {
            return "Number is odd "+n;
        }

    }

    private static String findOddEvenUsingBitOperator(int n){
        // We perform and (&) operator here , property is if both is 1 then return 1 else 0
        /**
         * 0 0 1 0  = > 2 in decimal
         * &   0 1 => 0
         *
         * */

        if ((n&1)==0){
            return "Number is even "+n;
        }else {
            return "Number is odd "+n;
        }
    }

}
