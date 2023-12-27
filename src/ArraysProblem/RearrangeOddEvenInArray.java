package ArraysProblem;

import java.util.Arrays;

public class RearrangeOddEvenInArray {
    /**
     * Problem
     * Given an array arr[] of size N containing equal number of odd and even numbers. Arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index.
     * Note: There are multiple possible solutions, Print any one of them. Also, 0-based indexing is considered.
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete the function reArrange() which takes an integer N and an array arr of size N as input and reArranges the array in Place without any extra space.
     * Input:
     * N = 6
     * arr[] = {3, 6, 12, 1, 5, 8}
     * Output:
     * 1
     * Explanation:
     * 6 3 12 1 8 5 is a possible solution.
     * The output will always be 1 if your
     * rearrangement is correct.
     */


    public static void main(String[] args) {
        reArrange(new int[]{3, 6, 12, 1, 5, 8}, 6);
        findSolution(new int[]{3, 6, 12, 1, 5, 8});
    }


    static void reArrange(int[] arr, int N) {
        // code here
        int[] odd = new int[N];
        int[] even = new int[N];

        int evenCount1 = 0;
        int oddCount1 = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 0) {
                even[evenCount1] = arr[i];
                evenCount1++;
            } else {
                odd[oddCount1] = arr[i];
                oddCount1++;
            }

        }


        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                arr[i] = even[evenCount];
                evenCount++;
            } else {
                arr[i] = odd[oddCount];
                oddCount++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    static void findSolution(int arr[]) {
        int i = 0, j = 1;
        int n = arr.length;

        while (i < n && j < n) {
            // If arr[i] is odd and arr[j] is even, swap them
            if (arr[i] % 2 == 1 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // Move both pointers by 2
                i += 2;
                j += 2;
            } else {
                // Move i if arr[i] is already at an odd index or pointing to an even number
                if (arr[i] % 2 == 0) {
                    i += 2;
                }
                // Move j if arr[j] is already at an even index or pointing to an odd number
                if (arr[j] % 2 == 1) {
                    j += 2;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
