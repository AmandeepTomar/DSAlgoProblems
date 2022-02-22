package ArraysProblem.sorting;

import java.util.Arrays;

/**
 * Time Complexity O(n2)
 * In this we have two array one is sorted and one in un-sorted.
 * Steps
 * Start with un sorted (0-n-1)
 * Sorted a[0] first element is sorted , we can assume this
 * now put temp =arr[1]
 * Now compare arr[1] with arr[0]
 * if arr[1]>arr[0] && j>=0{
 *     a[j+1]=a[j]
 * }
 * and j =i-1; =o
 * and now in the end just
 * put the temp value in a[j+1]=temp;
 * */
public class InsertionSortEx {
    public static void main(String[] args) {
        int arr[]={8,4,1,5,9,2};
        insertionSortSolutions(arr);
    }

    private static void insertionSortSolutions(int[] arr) {
        System.out.println("Un-Sorted Array is "+ Arrays.toString(arr));
        int n=arr.length;
        for (int i = 1; i <n-1 ; i++) {
            int temp=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        System.out.println("Sorted Array is "+ Arrays.toString(arr));
    }
}
