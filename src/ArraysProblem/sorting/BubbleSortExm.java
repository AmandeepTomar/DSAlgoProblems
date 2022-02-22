package ArraysProblem.sorting;

import java.util.Arrays;

/**
 * In each iteration its getting sort from last index.
 * that's why we use 2nd loop for a.length-1-i.
 * Complexity O(n2)
 *
 * */
public class BubbleSortExm {

    public static void main(String[] args) {
        int []a={4,3,7,1,5};
        int []a1={4,3,7,1,5,9,8,7,6,5,0};
        bubbleSort(a);
        bubbleSort(a1);
    }

    private static void bubbleSort(int[] a) {
        System.out.println("Un-Sorted Arrays is "+ Arrays.toString(a));
        for (int i = 0; i <a.length-1 ; i++) {
            boolean isSwap=false;
            for (int j = 0; j <a.length-i-1 ; j++) {
                if (a[j]>a[j+1]){
                    isSwap=true;
                    swapArrayElement(a,j+1,j);
                }
            }
            if (!isSwap){
                break;
            }
        }
        System.out.println("Sorted Arrays is "+ Arrays.toString(a));
    }

     static void swapArrayElement(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
