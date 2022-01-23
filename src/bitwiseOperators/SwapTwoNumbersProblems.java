package bitwiseOperators;

public class SwapTwoNumbersProblems {

    public static void main(String[] args) {
        int num1=Integer.MAX_VALUE,num2=999999999;
        swapTwoNoApproach1(num1,num2);
        System.out.println("======================");
        swapTwoNoWithTempVariable(num1,num2);
        System.out.println("======================");
        swapTwoNumberUsingxOrOperator(num1,num2);

    }


    private static void swapTwoNumberUsingxOrOperator(int num1, int num2) {
        /**
         * a ==5 , b==7
         *  a = a ^ b => 0 1 0 1 ^ 0 1 1 1 => 0 0 1 0   i.e 2
         *  b= a^b => 0 1 0 ^ 1 1 1 => 1 0 1 => 5 now b has 5 that is a b is swapped with a
         *  a = a^b => 0 1 0 ^ 1 0 1 => 1 1 1=> 7 so it is swapped now with b.
         * */

        System.out.println("Before Swap Num1 "+num1+" Num2 "+num2);

        num1 = num1 ^ num2;
         num2=num1 ^ num2;
         num1=num1 ^ num2;

        System.out.println("No after Swap Num1 "+num1+" Num2 "+num2);

    }

    private static void swapTwoNoApproach1(int num1, int num2) {
        // 5+10=15
        // num1=15-num1;
        // num1=15-num1;
        System.out.println("Before Swapping Number are num1 "+num1+" Num2 "+num2);
        int sum=num1+num2; // 15
        num1=sum-num1; // 15-5 , 10
        num2=sum-num1; //  15-10 = 5

        System.out.println("After Swapping number are num1 ="+num1+" Num2 is "+num2);
    }

    private static void swapTwoNoWithTempVariable(int num1, int num2) {
        System.out.println("Before Swapping Number are num1 "+num1+" Num2 "+num2);
        int temp=num1; // 15
        num1=num2; // 10
        num2=temp; //  15-10 = 5

        System.out.println("After Swapping number are num1 ="+num1+" Num2 is "+num2);
    }
}
