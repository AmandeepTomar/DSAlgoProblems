package ArraysProblem.ArrayReearangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifferenceWithK {

    public static void main(String[] args) {
        List<Integer> listArrays = new ArrayList<>();
        listArrays.add(10);
        listArrays.add(5);
        listArrays.add(3);
        listArrays.add(9);
        listArrays.add(2);
        solutionNo(listArrays,listArrays.size(),7);
    }

    private static void solutionNo(List<Integer> arr, int n,int k) {
        for(int i =0;i<n;i++){
            arr.set(i,arr.get(i)-k);
        }
        System.out.println(arr);
        Collections.sort(arr,(a, b)->Math.abs(a)-Math.abs(b));

        System.out.println(arr);
        for(int i =0;i<n;i++){
            arr.set(i,arr.get(i)+k);
        }

        System.out.println(arr);
    }
}
