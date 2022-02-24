package ArraysProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Subarray with given sum
 * Easy Accuracy: 39.71% Submissions: 100k+ Points: 2
 * Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * N = 5, S = 12
 * A[] = {1,2,3,7,5}
 * Output: 2 4
 * Explanation: The sum of elements
 * from 2nd position to 4th position
 * is 12.
 *
 *
 * Example 2:
 *
 * Input:
 * N = 10, S = 15
 * A[] = {1,2,3,4,5,6,7,8,9,10}
 * Output: 1 5
 * Explanation: The sum of elements
 * from 1st position to 5th position
 * is 15.
 * */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int n =arr.length;
        int sum=150;
        solution(arr,n,sum);
    }

    private static void solution(int[] arr, int n, int sum) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            int res=0;
            System.out.println(i);
            for (int j = i; j <n ; j++) {
                res +=arr[j];
                if (sum==res){
                    list.add(i+1);
                    list.add(j+1);
                    break;
                }else if (res>sum){
                    break;
                }
            }
            if (res==sum){
                break;
            }
        }

        if (list.isEmpty()){
            list.add(-1);
        }

        list.forEach(System.out::print );
    }
}
