package ArraysProblem;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {
    public static void main(String[] args) {

        int arr[] =new int[]{1,2,3,4,5};
        reverseArrayInNby2(arr);
        reverseArrayInN(arr);
        reverseUsingInBuild(arr);

    }

    static void reverseArrayInNby2(int [] arr){
        int len=arr.length;
        for (int i=0;i<len/2;i++){
            int temp=arr[len-(i+1)];
            arr[len-(i+1)]=arr[i];
            arr[i]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void reverseArrayInN(int arr[]){
        int len=arr.length;
        int arr1[]=new int[arr.length];
        for (int i = len-1; i >= 0; i--) {
            arr1[i]=arr[i];
        }
        System.out.println(Arrays.toString(arr1));
    }

    static void reverseUsingInBuild(int arr[]){

        Collections.reverse(Arrays.asList(arr));

        System.out.println(Arrays.toString(arr));

    }

}
