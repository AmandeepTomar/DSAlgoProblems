package ArraysProblem;

/***Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
 * //E.g. {1, 2, 3, 4, 5, 6, 7}.
 * // optput  {4 5 3 6 2 7 1}
 *
 *
 */

import java.util.Arrays;


public class RearrangeArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(0%2);

        int arr1[] = new int[arr.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }

        Arrays.sort(arr1);  // {1,2,3,4,5,6,7}
        int start=0;
        int end=arr1.length-1;
        for (int i = 0; i < arr1.length; i++) {
            if (i % 2 == 0) { //
                // i =0 , start=0 , arr[0] = arr1[start] arr[0]=1;, start =1
                // i==2 ,
                arr[i] = arr1[start];
                start++;

            } else {
                // i=1 , arr[1]=arr1[6] => arr[0]=7  end=5
                arr[i] = arr1[end];
                end--;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

        for (int i = 0; i <arr.length/2 ; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        // {4 5 3 6 2 7 1}
        System.out.println(Arrays.toString(arr));



    }
}
