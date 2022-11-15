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
public class FindLargestAndSmallestNumber {

    public static void main(String[] args) {
       // int arr[] = {3, 30, 34, 5, 9};
        int arr[] = {3, 1,2};
        System.out.println("Largest Number is "+ solutionLargest(arr));
        System.out.println("Smallest Number is "+smallest(arr));
    }

    private static String solutionLargest(int[] arr) {

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


    private static String smallest(int[] arr){
        /***
         *  input => int arr[] = {3, 30, 34, 5, 9}
         *  output => 9534330
         *
         *  WE WILL use string comparison here
         *  1. first convert int into string array
         *  2. then compare each pair of string Arrays.sort(strs,(str1+str2).compareTo(str2+str1)) and sort the array.
         *  3. then fetch each item and retunn as string.
         * */

        String[] strs = new String[arr.length];

        for (int i = 0; i <arr.length ; i++) {
            strs[i] = String.valueOf(arr[i]);
        }
        System.out.println("String array is "+Arrays.toString(strs));


    // Need to compare things in sorted array.
        Arrays.sort(strs,(str1,str2)->(str1+str2).compareTo(str2+str1)); // this will provide us smallest number
        System.out.println("String array After sorting and compare is "+Arrays.toString(strs));

      //  Arrays.sort(strs,(str1,str2)->(str2+str1).compareTo(str1+str2)); // this will provide us largest number

       // System.out.println("String array After sorting and compare is "+Arrays.toString(strs));

        if (strs[0].charAt(0)=='0') return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <strs.length ; i++) {
            sb.append(strs[i]);
        }

        System.out.println("Final Answer is "+sb.toString());
        return sb.toString();
    }

}
