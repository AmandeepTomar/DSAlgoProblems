package ArraysProblem;

import java.util.Arrays;

/**
 *
 * Given an array arr of n integers, task is to print the array in the order – smallest number, largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on.
 *
 * Example 1:
 *
 * Input:
 * n = 9
 * arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5}
 * Output:
 * 1 9 2 8 3 7 4 6 5
 * Explanation:
 * Smallest number is 1. Largest number is 9.
 * 2nd smallest number is 2. Then 2nd largest
 * number is 8. And so on.
 * Example 2:
 *
 * Input:
 * n = 4
 * arr[] = {1, 2, 3, 4}
 * Output:
 * 1 4 2 3
 * */
public class ReeArrangeArraySmallLarge {

    public static void main(String[] args) {
        int arr[]={1, 9, 2, 8, 3, 7, 4, 6, 5};
        solution(arr);
    }

    private static void solution(int[] arr) {
        Arrays.sort(arr);
        int j=arr.length-1;
        int k=0;
        int a[]=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            if (i%2!=0){
                a[i]=arr[j];
                j--;
            }else {
                a[i]=arr[k];
                k++;
            }
        }

        System.out.println(Arrays.toString(a));
    }
}
