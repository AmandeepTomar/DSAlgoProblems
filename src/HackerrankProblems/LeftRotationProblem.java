package HackerrankProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeftRotationProblem{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(rotLeft(list,1)); // [5, 1, 2, 3, 4]
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        Integer arr[]= new Integer[a.size()];
        //a.toArray(arr);


        for (int i = 0; i < arr.length ; i++) {
            int newIdex=(i+(arr.length-d))%arr.length;
            System.out.println(newIdex);
            arr[newIdex]=a.get(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("List "+a);
        return Arrays.asList(arr);

    }

}
