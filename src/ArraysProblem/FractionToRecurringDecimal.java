package ArraysProblem;

import java.util.HashMap;

/***
 * Given a fraction. Convert it into a decimal.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * Example 1:
 *
 * Input: numerator = 1, denominator = 3
 * Output: "0.(3)"
 * Explanation: 1/3 = 0.3333... So here 3 is
 * recurring.
 * Example 2:
 *
 * Input: numerator = 5, denominator = 2
 * Output: "2.5"
 * Explanation: 5/2 = 2.5
 *
 *
 * Your Task:
 * You don't need to read or print anyhting. Your task is to complete the function fractionToDecimal() which takes numerator and denominator as input parameter and returns its decimal form in string format.
 *
 * Note: In case, the numerator is divisible by the denominator, just print the integer value.
 *
 *
 * Expected Time Compelxity: O(k) where k is constant.
 * Expected Space Complexity: O(k)
 *
 * ALGO Simple
 *
 * */

public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        System.out.println(findFractionToRecurringDecimal(8,4));
        System.out.println(findFractionToRecurringDecimal(428,125));
        System.out.println(findFractionToRecurringDecimal(14,3));
        System.out.println(findFractionToRecurringDecimal(47,18));
        System.out.println(findFractionToRecurringDecimal(93,7));
    }
    
    static String findFractionToRecurringDecimal(int numerator,int denominator){
        StringBuilder ans=new StringBuilder();
        int quotient = numerator/denominator; // calculate quotient
        int rem=numerator%denominator;  // calculate reminder

        ans.append(quotient); // quotient is always append in answer.

        if (rem==0)
        return ans.toString(); // return coz reminder is 0.
        else {
            ans.append("."); // add decimal , its just simple divide rune put decimal in ans and take 0 or multiply by 10 in reminder.
            HashMap<Integer,Integer> remRepeat=new HashMap<>();
            while (rem!=0){
                if (remRepeat.containsKey(rem)){  // just check is reminder is repeating if yes
                    int len=remRepeat.get(rem); // get the length on with it repeat
                    ans.insert(len,"(");  // insert at position where it repeats.
                    ans.append(")"); // append closing bracket in end.
                    break;
                }else { // IF reminder is not repeat follow simple math multiply by 10 , and find new quotient and reminder and append quotient in ans.
                    remRepeat.put(rem,ans.length()); // save the reminder in map.
                    rem = rem * 10; // multiply by 10
                    quotient = rem / denominator; // find quotient
                    rem = rem % denominator; // find reminder.
                    ans.append(quotient); // addend quotient in ans.
                }
            }
        }
        return ans.toString();
    } 
}
