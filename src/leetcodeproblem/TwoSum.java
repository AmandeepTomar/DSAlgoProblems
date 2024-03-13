package leetcodeproblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * */
public class TwoSum {

    public static void main(String[] args) {
       // [2,7,11,15], target = 9
        int arr[]=new int[]{2,7,11,15};
        int target = 9;
        int res[]=twoSum(arr,target);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int arr[],int target){
        int res[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            int find = target - arr[i];
            if (map.containsKey(find)){
                res[0] = map.get(find);
                res[1]=i;
                break;
            }
            map.put(arr[i],i);
        }
        return res;
    }
}
