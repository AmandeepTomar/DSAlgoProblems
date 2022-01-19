package ArraysProblem;

import java.util.Arrays;

public class FindIndexOfSum {
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int target=9;
        int[] result=twoSum(arr,target);
        System.out.println(Arrays.toString(result));

        int arr1[]={3,2,4,15};
        int target1=6;
        int[] result1=twoSum(arr1,target1);
        System.out.println(Arrays.toString(result1));
    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int find=target-nums[i];
            arr[0]=i;
            for(int j=i+1;j<nums.length;j++){
                if(find==nums[j]){
                    arr[1]=j;
                    return arr;
                }
            }
        }
        return arr;
    }
}
