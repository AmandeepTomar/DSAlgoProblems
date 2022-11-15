package ArraysProblem;

import java.util.Arrays;
import java.util.HashMap;

public class FindIndexOfSum {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
        twoSumWithN(arr,target);

        int arr1[] = {3, 2, 4, 15};
        int target1 = 6;
        int[] result1 = twoSum(arr1, target1);
        System.out.println(Arrays.toString(result1));
        twoSumWithN(arr1,target1);
    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            arr[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (find == nums[j]) {
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void twoSumWithN(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean isFind=false;
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                System.out.println("index are [" + map.get(find) + "," +i +"]");
                isFind=true;
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        if (!isFind){
            System.out.println("No match found");
        }
    }
}
