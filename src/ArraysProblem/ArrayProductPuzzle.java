package ArraysProblem;

import java.util.Arrays;

/**
 * Product array puzzle
 * Given an array nums[] of size n, construct a Product Array P (of same size n)
 * such that P[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example 1:
 * <p>
 * Input:
 * n = 5
 * nums[] = {10, 3, 5, 6, 2}
 * Output:
 * 180 600 360 300 900
 * Explanation:
 * For i=0, P[i] = 3*5*6*2 = 180.
 * For i=1, P[i] = 10*5*6*2 = 600.
 * For i=2, P[i] = 10*3*6*2 = 360.
 * For i=3, P[i] = 10*3*5*2 = 300.
 * For i=4, P[i] = 10*3*5*6 = 900.
 * Example 2:
 * <p>
 * Input:
 * n = 2
 * nums[] = {12,0}
 * Output:
 * 0 12
 * <p>
 * Your Task:
 * You do not have to read input. Your task is to complete the function productExceptSelf() that takes array nums[] and n as input parameters and returns a list of n integers denoting the product array P. If the array has only one element the returned list should should contains one value i.e {1}
 * Note: Try to solve this problem without using the division operation.
 * <p>
 * <p>
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 */
public class ArrayProductPuzzle {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        solution1(arr);
        solutionWithNSquare(arr);

    }

    private static void solution1(int[] arr) {
        // left array of product[1,2,6,24]
        // right array of product[24,24,12,4]
        // o/p= > left[i-1]*right[i+1] i.e from 1 to n-2 [12,8]
        // o[0]=right[1]; 24
        // o[n-1]=left[n-2];6
        /**
         * 1. product of left {1,2,6,24}
         * 2. product of right {24,24,12,4}
         * 3. output
         * 4. output[0] = right[1] => 24.
         * 5. output[length-1] => left[n-2] => 6.
         * 6. 1 to n-2.
         *      output[i=1] = left[i-1]+right[i+1]; 1*12
         *      output[i=2] = left[i-1]+right[i+1]; 2*4 => 8
         * */

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] output = new int[arr.length];

        // fill left product
        int temp = 1;
        for (int i = 0; i < arr.length; i++) {
            temp = temp * arr[i];
            left[i] = temp;
        }
        System.out.println("Left Product Array " + Arrays.toString(left));
        int temp2 = 1;
        for (int i = left.length - 1; i >= 0; i--) {
            temp2 = temp2 * arr[i];
            right[i] = temp2;
        }
        System.out.println("Right Product Array " + Arrays.toString(right));
        //{1,2,3,4}
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                output[0] = right[1];
            } else if (i == arr.length - 1) {
                output[arr.length - 1] = left[arr.length - 2];
            } else {
                output[i] = left[i - 1] * right[i + 1];
            }
        }

        System.out.println("Output Product Array " + Arrays.toString(output));

    }


    // this one is not optimize. it will provide the solution in bing o of n square time complexity.
    private static void solutionWithNSquare(int arr[]) {
        int output[]=new int[arr.length];
        int product = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    product = product * arr[j];
                }
            }
            output[i]=product;
            product=1;
        }

        System.out.println("Solution with N2 "+Arrays.toString(output));
    }

}
