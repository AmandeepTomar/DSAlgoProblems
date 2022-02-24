package ArraysProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 6
 * arr = {1, 2, 3, 6, 5, 4}
 * Output: {1, 2, 4, 3, 5, 6}
 * Explaination: The next permutation of the
 * given array is {1, 2, 4, 3, 5, 6}.
 * Example 2:
 * <p>
 * Input: N = 3
 * arr = {3, 2, 1}
 * Output: {1, 2, 3}
 * Explaination: As arr[] is the last
 * permutation. So, the next permutation
 * is the lowest one.
 */
public class NextPermutationProblem {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 5, 4};
        int arr2[] = {3, 2, 1};

      //  solutionNextPermutation(arr);
        perfectSolution(arr.length,arr);
    }


    private static List<Integer>  perfectSolution(int N, int arr[]){
                //arr = {1, 2, 3, 6, 5, 4}
                // Output: {1, 2, 4, 3, 5, 6}
            List<Integer> list = new ArrayList<>(arr.length);
            int preLarge=N-1;
            for(int i=N-2;i>=0;i--){
                // (i-> 4 , preLarge=5) arr[5] <=arr[4] =>  4 <=5
                //(i-> 3 , preLarge=4) arr[4] <=arr[3] => 5<=6
                //(i-> 2 , preLarge=3) arr[3] <=arr[2] => 6<=3 , false here now break
                if(arr[preLarge]<=arr[i]){
                    preLarge=i; // preLarge = 4
                                // preLarge =3
                    System.out.println("Prelarge "+preLarge+" and i "+i);

                }else   break;
            }

            if(preLarge!=0) {
                System.out.println("PreLarge"+preLarge);
                // preLarge =3
                //arr = {1, 2, 3, 6, 5, 4}
                int nextMax=preLarge;
                for(int i=preLarge+1;i<N;i++){
                    // (i=3+1=4, netMax=3) (arr[4]>arr[3-1] && arr[4]<arr[3]);=>(5>3 && 5<6) , netMax=4
                    // (i->5 , netmax=4 )(arr[5]>arr(preLartge-1[3-1]) && arr[i, 5]<arr[netMaxt, 4])=(4>2 && 4<5) , netmax=5
                    //
                    if(arr[i]>arr[preLarge-1] && arr[i]<arr[nextMax])
                        nextMax=i;
                    System.out.println("Nextmax "+nextMax+" Prelarge "+preLarge+" i "+i);
                }
                int temp=arr[preLarge-1];
                arr[preLarge-1]=arr[nextMax];
                arr[nextMax]=temp;
                System.out.println(" Array after swap"+Arrays.toString(arr));
                Arrays.sort(arr,preLarge, N);

            }else Arrays.sort(arr);

            for (int a: arr) list.add(a);

        System.out.println(list);
            return list;
    }


    private static void solutionNextPermutation(int[] arr) {
        // {1, 2, 3, 6, 5, 4}; // Input
        // {1, 2, 4, 3, 5, 6} output
        int copyArr[]=arr;

        int n = arr.length - 1;
        int last = arr[n];
        int smallIndex = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < last) {
                smallIndex = i;

                break;
            }
        }

        if (smallIndex!=-1) {
            System.out.println(smallIndex);
            swapElement(arr, smallIndex, n);
            System.out.println(Arrays.toString(arr));

            List<Integer> list = new ArrayList<>();

            for (int i = smallIndex + 1; i <= n; i++) {
                list.add(arr[i]);
            }
            Collections.sort(list);
            System.out.println("Sorted List " + list);

            for (int i = 0; i < list.size(); i++) {
                arr[smallIndex + 1 + i] = list.get(i);
            }
        }else {
            Arrays.sort(arr);
        }


        System.out.println("Output     "+Arrays.toString(copyArr)+"\n Output is "+Arrays.toString(arr));

    }

    private static void swapElement(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
