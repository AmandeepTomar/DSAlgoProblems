package recursion;

public class Reverse_Integer_Number {

    public static void main(String[] args) {
        int num = 543210;
        int num2 = 0;

        reverseAIntegerNumber(num);
        System.out.println();
        if (num2 == 0) {
            System.out.println(0);
        } else
            reverseAIntegerNumber(num2);

        int result = 0;
        System.out.println("Result = > " + reverseAIntegerNumber(num, result));
        System.out.println("After " + result);

        System.out.println("Reverse String " + reverseInt("600", 0, ""));
        System.out.println("reverseStringWithoutExtraParams Reverse String " + reverseStringWithoutExtraParams("70000"));
        reverseStringWithRecursionStack("9000", 0, "");
    }

    private static void reverseAIntegerNumber(int num) {
        if (num == 0) return;
        System.out.print(num % 10);
        reverseAIntegerNumber(num / 10);

    }

    private static int reverseAIntegerNumber(int num, int result) {
        // in this code 600 will reverse to 6. that is methodically correct ,
        // but if some one insist to print it 006 then convert in string and reverse it.
        if (num == 0) return result;
        result = result * 10 + num % 10;
        return reverseAIntegerNumber(num / 10, result);
    }

    private static String reverseInt(String num, int index, String res) {
        if (index == num.length()) return res;
        res = num.charAt(index) + res;
        return reverseInt(num, index + 1, res);
    }

    private static void reverseStringWithRecursionStack(String str, int index, String res) {
        if (str.length() == index) return;
        reverseStringWithRecursionStack(str, index + 1, res);
        res = res + str.charAt(index);
        System.out.print(res);
    }

    private static String reverseStringWithoutExtraParams(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseStringWithoutExtraParams(str.substring(1)) + str.charAt(0);
    }
}
