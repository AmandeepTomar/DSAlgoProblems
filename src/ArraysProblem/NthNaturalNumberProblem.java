package ArraysProblem;
/**
 *Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 8
 * Output:
 * 8
 * Explanation:
 * After removing natural numbers which contains
 * digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
 * and 8th number is 8.
 * Example 2:
 *
 * Input:
 * N = 9
 * Output:
 * 10
 * Explanation:
 * After removing natural numbers which contains
 * digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
 * and 9th number is 10.
 *
 * Solution :-
 * if base 2 no -[0,1]
 * if base 3 no - [0,1,2]
 * if base 9 no - [0,1,2,3,4,5,6,7,8]
 *
 * so is like calculate the binary from decimal where N=NUM , and removing 2 means base 2.
 *
 *   (5)base 2=> 2|5|1
 *                |2|0
 *                |1|
 *                => 101 => we can write it like 1*1 + 0*10 + 1*100 => 101.
 *
 *   (8) base 9
 * */
public class NthNaturalNumberProblem {

    public static void main(String[] args) {

        nthNumberProblem(8);
        nthNumberProblem(9);
    }

    private static void nthNumberProblem(long num) {

        long temp=1;
        long res=0;
        while (num>0){
            res =res+temp*(num%9);
            temp *=10;
            num /=9;
        }
        System.out.println("result is "+res);
    }
}
