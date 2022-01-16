package ArraysProblem;

import java.util.Arrays;

public class LeftAndRightRotationProblem {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int times=2;
        rightRotationApproach1(arr,times);
    }

    private static void rightRotationApproach1(int[] arr, int times) {
        // right rotation means shift one element to the right
        // like 1,2,3,4,5 After one right shift it will be 5,1,2,3,4
        // 2 nd 4,5,1,2,3
        int n=arr.length;

        for (int i = 0; i <times ; i++) {
            int temp=arr[n-1];
            for (int j = n-1; j > 0 ; j--) {
                System.out.println(j);
                arr[j]=arr[j-1];
            }
            arr[0]=temp;
        }
        System.out.println("Right rotation of Array"+ Arrays.toString(arr)+"times "+times);
    }
}
