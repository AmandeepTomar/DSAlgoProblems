package ArraysProblem;


import java.util.Arrays;

/**
 *
 * Input => {3,1,2,4,0,1,3,2}
 * Out put is 3+5 =>8
 * 2+1+3+2
 *ALGO
 * Used Array Pre processing
 * */
public class RainWaterProblem {
    public static void main(String[] args) {
        int [] arr={3,1,2,4,0,1,3,2};
        rainWatre(arr);
    }

    private static void rainWatre(int[] arr) {
        //Steps -> Pre process Array
        // left ->Math.max(left[i-1],arr[i])
        // right -> Math.max(right[i+1],arr[i])-> from right
        // get the min between left and right minus the index value.
        //          int min =Math.min(left[i],right[i])-arr[i];

        int left[]=new int[arr.length];
        int right[]=new int[arr.length];
        left[0]=arr[0];
        right[arr.length-1]=arr[arr.length-1];
        for (int i = 1; i <arr.length ; i++) {
            left[i]=Math.max(arr[i],left[i-1]);
        }

        for (int i = arr.length-2; i >=0 ; i--) {
            right[i]=Math.max(arr[i],right[i+1]);
        }

        System.out.println("Left"+Arrays.toString(left));
        System.out.println("Right"+Arrays.toString(right));
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            int min =Math.min(left[i],right[i])-arr[i];
            sum=sum+min;
        }

        System.out.println("Total Water is"+sum);

    }
}
