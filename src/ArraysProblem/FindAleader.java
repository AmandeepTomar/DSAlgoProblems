package ArraysProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAleader {


    public static void main(String[] args) {
        int arr[] = new int[]{16 ,17, 4, 3, 5, 2};
      //  findALeader(arr,arr.length);

        String str = "hello";
        int size = str.toCharArray().length;
        System.out.println(size);
    }

    public int lengthOfLastWord(String s) {
        String str[] = s.trim().split(" ");
        String lastWord = str[str.length-1];

        return   lastWord.toCharArray().length;
    }

    private static void findALeader(int[] arr, int n) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int leader = arr[n-1];
//        for (int i = n-2; i > = 0; i--) {
//
//        }

    }
}
