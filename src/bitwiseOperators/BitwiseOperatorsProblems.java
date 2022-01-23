package bitwiseOperators;

/**
 * Bitwise operators are used to perform the manipulation of individual bits of a number. They can be used with any
 * integral type (char, short, int, etc.). They are used when performing update and query operations of the
 * Binary indexed trees.
 * <p>
 * Bitwise OR (|)
 * This operator is a binary operator, denoted by ‘|’. It returns bit by bit OR of input values, i.e.,
 * if either of the bits is 1, it gives 1, else it shows 0.
 * ===============
 * A  | B  (A|B)
 * 0    0    0
 * 0    1    1
 * 1    0    1
 * 1    1    1
 * ==================
 * <p>
 * Bitwise AND (&)
 * <p>
 * This operator is a binary operator, denoted by ‘&.’ It returns bit by bit AND of input values, i.e.,
 * if both bits are 1, it gives 1, else it shows 0.
 * ===============
 * *  A  & B  (A&B)
 * *  0    0    0
 * *  0    1    0
 * *  1    0    0
 * *  1    1    1
 * ==================
 * <p>
 * Bitwise XOR (^)
 * <p>
 * This operator is a binary operator, denoted by ‘^.’ It returns bit by bit XOR of input values, i.e.,
 * if corresponding bits are different, it gives 1, else it shows 0.
 * *  ===============
 * A  ^ B  (A^B)
 * 0    0    0
 * 0    1    1
 * 1    0    1
 * 1    1    0
 * ==================
 * <p>
 * Bitwise Complement (~)
 * <p>
 * This operator is a unary operator, denoted by ‘~.’ It returns the one’s complement representation of the input
 * value, i.e., with all bits inverted, which means it makes every 0 to 1, and every 1 to 0.
 * 1 ~ 0
 * 0 ~ 1
 * 1 0 0 1 ~ 0 1 1 0
 * <p>
 * <p>
 * Right shift (>>)
 * - Divide by 2
 * <p>
 * <p>
 * Left shift (<<)
 * - Multiply by 2
 */

public class BitwiseOperatorsProblems {

    public static void main(String[] args) {
        leftShiftOperator(12, 2);
        rightShift(2, 2);
        andOperator(8, 10);
        orOperator(8, 10);
        xOrOperator(2,5);
    }

    /**
     * it is like Multiply by 2 , so its like 2 >> 1 that is 2 Ans ,2 >> 2 that is 4 Ans.
     * it is used to  shift the element to left
     * like 1100 (12) << 1 -> 11000 (24) <<  1 -> 110000(48)
     * - It is used when we use num * 2 in loop for int so we can do num>>1 that is fast from previous one
     */
    private static void leftShiftOperator(int num, int times) {
        int ans = num << times;
        System.out.println(" Answer is Afet " + times + " Number is" + ans);
    }

    /**
     * it is like divide by 2 , so its like 2 >> 1 that is 1 Ans ,2 >> 2 that is 0 Ans.
     * it is used to  shift the element right
     * like 1100 (12) >> 1 -> 0110(6)>>1 -> 0011(3)
     * - It is used when we use num /2 in loop for int so we can do num>>1 that is fast from previous one
     */
    private static void rightShift(int num, int times) {

        int ans = num >> times;
        System.out.println(" Answer is Afet " + times + " Number is " + ans);

    }

    /**
     * This operator is a binary operator, denoted by ‘&.’ It returns bit by bit AND of input values, i.e.,
     * if both bits are 1, it gives 1, else it shows 0.
     * <p>
     * 4 & 5 =>
     * 0 1 0 0 & 0 1 0 1 => 0 1 0 1 => 4 is Answer
     * ===============
     * *  A  & B  (A&B)
     * *  0    0    0
     * *  0    1    0
     * *  1    0    0
     * *  1    1    1
     * ==================
     */


    private static void andOperator(int num1, int num2) {
        int ans = num1 & num2;
        System.out.println(num1 + "&" + num2 + " is " + ans);
    }

    /**
     * Bitwise AND (&)
     * <p>
     * This operator is a binary operator, denoted by ‘&.’ It returns bit by bit AND of input values, i.e.,
     * if both bits are 1, it gives 1, else it shows 0.
     * ===============
     * *  A  & B  (A&B)
     * *  0    0    0
     * *  0    1    0
     * *  1    0    0
     * *  1    1    1
     * ==================
     * <p>
     * 4 | 5 => 5
     * 0 1 0 0 | 0 1 0 1 => 0 1 0 1
     */
    private static void orOperator(int num1, int num2) {
        int ans = num1 | num2;
        System.out.println(num1 + " | " + num2 + " is =>" + ans);
    }

    /**
     * Bitwise XOR (^)
     * <p>
     * This operator is a binary operator, denoted by ‘^.’ It returns bit by bit XOR of input values, i.e.,
     * if corresponding bits are different, it gives 1, else it shows 0.
     * *  ===============
     * A  ^ B  (A^B)
     * 0    0    0
     * 0    1    1
     * 1    0    1
     * 1    1    0
     * ==================
     *
     * 4 ^ 5 => 1
     * 0 1 0 0 ^ 0 1 0 1 => 0 0 0 1
     */
    private static void xOrOperator(int num1, int num2) {
        int ans = num1 ^ num2;
        System.out.println(num1+" ^ "+num2+" => "+ans);

    }

}
