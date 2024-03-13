package leetcodeproblem;

/**
 * 53. Maximum Subarray
 * Solved
 * Medium
 * Topics
 * Companies
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * */
public class MaximumSubArray {

    public static void main(String[] args) {
        int arr[]=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int arr1[]=new int[]{-1,-5};
        int arr2[]=new int[]{-5,-1};
        int res = findMaximumSumArray(arr);
        System.out.println(res+" Should be 6");
        int res2 = findMaximumSumArray(arr1);
        System.out.println(res2+" Should be -1");
        int res3 = findMaximumSumArray(arr2);
        System.out.println(res3+" Should be -1");
    }

    private static int findMaximumSumArray(int nums []){
        int maxSum = nums[0];
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum +=nums[i];
            maxSum = Math.max(sum,maxSum);
            if (sum<0) sum=0;
        }
        return maxSum;
    }
}
