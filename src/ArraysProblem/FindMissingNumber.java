package ArraysProblem;


import java.util.Arrays;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N. Find the missing element.
 *
 * Example 1:
 *
 * Input:
 * N = 5
 * A[] = {1,2,3,5}
 * Output: 4
 * Example 2:
 *
 * Input:
 * N = 10
 * A[] = {6,1,2,8,3,4,7,10,5}
 * Output: 9
 *
 * Your Task :
 * You don't need to read input or print anything. Complete the function MissingNumber() that takes array and N as input  parameters and returns the value of the missing number.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 * */
public class FindMissingNumber {

    public static void main(String[] args) {
       // int arr[]={2};
        int arr[]={6,1,2,8,3,4,7,10,5};
      //  System.out.println("Mission no is = "+findMissionNoInNTime(arr));
        System.out.println("Mission no is = "+findMissingNoInNby2(arr));
      //  System.out.println("Factorial no is = "+calculatefactorial(6));

    }

    private static int findMissionNoInNTime(int[] arr) {
        // First we need to sort the Array
        Arrays.sort(arr);
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]!=i+1){
                return i+1;
            }
        }
        return arr.length+1;
    }

    private static int findMissingNoInNby2(int[] arr){
        Arrays.sort(arr);
        int j=arr.length-1;
        for (int i = 0; i <arr.length/2 ; i++,j--) {
            if (arr[i]!=i+1){
                return i+1;
            }
            if (arr[j]!=arr.length-1-i){
                return arr.length-1-i+1;
            }
        }
        return arr.length+1;
    }

    // todo Need to complete this , in n/2
   static int MissingNumber(int array[], int n) {
        Arrays.sort(array);
        int j=0;

            j=n-2;

        for (int i = 0; i <n/2 ; i++,j--) {
            if (array[i]!=i+1){
                return i+1;
            }
            if (n>3) {
                if (array[j] != array.length - 1 - i) {
                    return array.length - 1 - i + 1;
                }
            }

        }
        return array.length+1;
    }


    static int calculatefactorial(int n){
        if(n==0 || (n==1 || n==2)){
            return n;
        }else{
            return   n*calculatefactorial(n-1);
        }
    }
}
