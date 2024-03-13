package recursion;

import javax.swing.*;

public class JosephusProblemSolution {

    public static void main(String[] args) {
        int winner = josephusProbleSolution(5, 3);
        System.out.println(winner);

        System.out.println(palindromeString("racecar"));
        StringBuilder res = new StringBuilder();
        String str = "abc";
        String result = "";
        poerSet(str, 0, result);
       // System.out.println("Result is " + res.toString());
    }

    private static int josephusProbleSolution(int num, int k) {
        if (num == 1) return 0;
        return (josephusProbleSolution(num - 1, k) + k) % num;

        // greeks of h=greeks solution.
        //  return (josephusProbleSolution(num-1,k)+k-1)%num+1;
    }


    private static String palindromeString(String str) {
        if (str.length() == 0) return "";
        return str.substring(str.length() - 1) + palindromeString(str.substring(0, str.length() - 1));
    }

    private static void poerSet(String str, int n, String current) {
        if (n == str.length()){
            System.out.println(current);
            return;
        }
        poerSet(str,n+1,current+str.charAt(n));
        poerSet(str,n+1,current);
    }
}
