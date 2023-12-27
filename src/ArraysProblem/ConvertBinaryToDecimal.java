package ArraysProblem;

import java.util.Arrays;

public class ConvertBinaryToDecimal {
    public static void main(String[] args) {
        String binary="0111111111111111111111111111111111111111111111111111111111111111";
        String binary1="1111111111111111111111111111111111111111111111111111111111111111";
        String binary2="001101"; // 13

        findDecimal(binary2.toCharArray());
        findDecimal(binary.toCharArray());
        findDecimal(binary1.toCharArray());

    }

    private static void findDecimal(char[] arr) {
        double decimal=0;
        for (int i = 1; i < arr.length ; i++) {
            System.out.println(arr[i]);
            if (arr[i]=='1'){
                decimal=decimal+Math.pow(2,(arr.length-1-i));
            }
        }
        System.out.println("Decimal values id "+(long)decimal+" of binary "+ Arrays.toString(arr));
    }
}
