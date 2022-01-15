package ArraysProblem;

import java.util.Arrays;
import java.util.HashSet;

/**
 * In this problem we have two sorted array and we find the Intersection and union from arrays.
 *
 * */
public class UnionAndIntersectionProblem {


    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5};
        int arr2[]={2,3,4,5,6,7};
        findUnion(arr1,arr2);
        findIntersection(arr1,arr2);
    }



    private static void findUnion(int[] arr1, int[] arr2) {
        System.out.println("Array one "+ Arrays.toString(arr1));
        System.out.println("Array two "+ Arrays.toString(arr2));
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i <arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println(set.toString());
    }

    private static void findIntersection(int[] arr1, int[] arr2) {

    }

}
