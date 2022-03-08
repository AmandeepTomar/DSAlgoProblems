package ArraysProblem;

import java.util.Arrays;

/**
 * Largest Number formed from an Array
 * Medium Accuracy: 50.0% Submissions: 26349 Points: 4
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * Arr[] = {3, 30, 34, 5, 9}
 * Output: 9534330
 * Explanation: Given numbers are {3, 30, 34,
 * 5, 9}, the arrangement 9534330 gives the
 * largest value.
 * Example 2:
 *
 * Input:
 * N = 4
 * Arr[] = {54, 546, 548, 60}
 * Output: 6054854654
 * Explanation: Given numbers are {54, 546,
 * 548, 60}, the arrangement 6054854654
 * gives the largest value.
 * */
public class FindLargestNumber {

    public static void main(String[] args) {
        int arr[] = {3, 30, 34, 5, 9};
        System.out.println("Largest Number is "+solution(arr));
    }

    private static String solution(int[] arr) {

        String strs[]=new String[arr.length];

        for (int i = 0; i <arr.length ; i++) {
            strs[i]=String.valueOf(arr[i]);
        }

        Arrays.sort(strs,(str1,str2)->(str2+str1).compareTo(str1+str2));

        if (strs[0].charAt(0)=='0') return "0";

        StringBuilder sb =new StringBuilder();
        for (String str:strs){
            sb.append(str);
        }
        return sb.toString();
    }

}
