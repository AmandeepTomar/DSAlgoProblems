package ArraysProblem;

import java.util.*;

/**
 * Sort 0 , 1 and 2 without using sorting
 *
 * */
public class Sort0s1sand2sWithoutSorting {

    public static void main(String[] args) {
        int arr[]={1,1,0,1,0,2,1,0,1,2};
        approach1(arr);
        approach2(arr);

        List<Integer> list = new ArrayList<>();

        Collections.sort(list, (o1, o2) -> Math.abs(o1)-Math.abs(o2));
    }

    private static void approach2(int[] arr) {
        // case0 -> swap 0 with i and i++ j++;
        // case 1 -> j++;
        // case 2->swap 2 with 1 means k--

        int i=0;
        int j=0;
        int k=arr.length-1;

        while(j<=k){
            switch (arr[j]){
                case 0: swap(arr,i,j);
                        i++;
                        j++;
                    break;
                case 1: j++;
                    break;
                case 2:swap(arr, j,k);
                         k--;
                    break;
                default:break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

     static void swap(int[] arr, int i, int j) {
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    private static void approach1(int[] arr) {
         int zero=-1;
         int one=-1;
         int two=-1;
        int i=0;
        int j=arr.length;
        while (i<j){
            switch (arr[i]){
                case 0: zero++;
                        break;
                case 1: one++;
                        break;
                case 2:two++;
                        break;
                default:break;
            }
            i++;
        }
        System.out.println(" Zero "+zero+" One "+one+" two"+two);

        for (int k = 0; k <arr.length ; k++) {
            if (zero!=-1){
                arr[k]=0;
                zero--;
            }else if (one!=-1){
                arr[k]=1;
                one--;
            } else if (two!=-1){
                arr[k]=2;
                two--;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

}
