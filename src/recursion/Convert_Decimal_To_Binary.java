package recursion;

public class Convert_Decimal_To_Binary {

    public static void main(String[] args) {
        int num = 100;
        convertDecimalToBinary(num);
    }

    private static void convertDecimalToBinary(int num) {
        if (num == 0) return;
        convertDecimalToBinary(num / 2);
        System.out.print(num % 2 + " ");
    }
}
