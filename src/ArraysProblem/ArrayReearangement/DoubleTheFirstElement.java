package ArraysProblem.ArrayReearangement;

import java.util.Arrays;

/**
 * For a given array of n integers and assume that ‘0’ is an invalid number and all others as a valid number.
 * Convert the array in such a way that if both current and next element is valid and both have same value then
 * double current value and replace the next number with 0. After the modification, rearrange the array such
 * that all 0’s shifted to the end.
 * Examples:
 * <p>
 * Input : arr[] = {2, 2, 0, 4, 0, 8}
 * Output : 4 4 8 0 0 0
 * <p>
 * Input : arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8}
 * Output :  4 2 12 8 0 0 0 0 0 0
 */
public class DoubleTheFirstElement {

    public static void main(String[] args) {
      //  int arr[] = {2, 2, 0, 4, 0, 8};
        int arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        solution1(arr, arr.length);
    }

    private static void solution1(int[] arr, int length) {

        for (int i = 0; i < length - 2; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
        }

        System.out.println(Arrays.toString(arr));
        shiftAllZeroToEnd(arr);
    }

    private static void shiftAllZeroToEnd(int[] arr) {
        int lastSeenIndex=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                swapArraytElement(arr,lastSeenIndex,i);
                lastSeenIndex++;
            }
        }

        System.out.println("FInal solution "+Arrays.toString(arr));


    }

    private static void swapArraytElement(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }


}
