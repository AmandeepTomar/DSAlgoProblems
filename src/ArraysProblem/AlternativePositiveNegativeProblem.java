package ArraysProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
 * Note: Array should start with positive number.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 9
 * Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
 * Output:
 * 9 -2 4 -1 5 -5 0 -3 2
 * Example 2:
 *
 * Input:
 * N = 10
 * Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * Output:
 * 5 -5 2 -2 4 -8 7 1 8 0
 *
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters. You need to modify the array itself.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 * */
public class AlternativePositiveNegativeProblem {

    public static void main(String[] args) {
        int arr[]={-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        alterNativePositiveNegativeElements(arr);
    }


    private static void alterNativePositiveNegativeElements(int[] arr) {
        List<Integer> pList=new ArrayList<>();
        List<Integer> nList=new ArrayList<>();

        for (int i=0;i<arr.length;i++){
            if (arr[i]>=0){
                pList.add(arr[i]);
            }else {
                nList.add(arr[i]);
            }
        }

        System.out.println(pList.toString());
        System.out.println(nList.toString());

        List<Integer> newList=(pList.size()>nList.size()) ? pList : nList;

        for (int i = 0; i <arr.length ; i++) {
            if (!nList.isEmpty() && !pList.isEmpty()){
                if (i%2==0){
                    arr[i]=pList.remove(0);
                }else {
                    arr[i]=nList.remove(0);
                }
            }else {
                arr[i]=newList.remove(0);
            }
        }

        System.out.println("Alternative Array is "+ Arrays.toString(arr));
    }

}
