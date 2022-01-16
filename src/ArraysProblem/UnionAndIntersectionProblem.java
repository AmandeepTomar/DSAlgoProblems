package ArraysProblem;

import java.util.Arrays;
import java.util.HashSet;

/**
 * In this problem we have two sorted array and we find the Intersection and union from arrays.
 *
 * */
public class UnionAndIntersectionProblem {


    public static void main(String[] args) {
        int arr1[]={1,2,3,3,4,5};
        int arr2[]={3,4,5,6,7};
        findUnion(arr1,arr2);
        findIntersection(arr1,arr2);
        int arr3[]={1,2,3,3,4,5,7};
        int arr4[]={3,4,5,6,7};

        findIntersection(arr3,arr4);

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

        System.out.println(" Union ="+set.toString());
    }

    private static void findIntersection(int[] arr1, int[] arr2) {
//        int arr1[]={1,2,3,4,5};
//        int arr2[]={2,3,4,5,6,7};
        /**
         * We traverse with one loop ,
         * if we get both array have same element then increment j that is representing 2nd array.
         * if
         * */
            int m=arr2.length;
            int arr[]=new int[arr1.length];
            int n=arr1.length;
            int i=0,j=0;
            HashSet<Integer>set=new HashSet<>();
        while (i<n && j<m) {
            if (arr1[i]<arr2[j]){
                // do nothing coze i++ is already increaing
                i++;
            }else if (arr1[i]>arr2[j]){
                j++;
            }else {
                set.add(arr1[i]);
                    arr[j]=arr1[i];
                    j++;
                    i++;
            }
        }
        System.out.println("Intersection Array is ="+Arrays.toString(arr));
        System.out.println("Intersection set is "+set);

    }

}
