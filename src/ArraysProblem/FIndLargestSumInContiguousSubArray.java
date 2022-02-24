package ArraysProblem;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number)
 * which has the maximum sum and return its sum.
 *
 * Input:
 * N = 5
 * Arr[] = {1,2,3,-2,5}
 * Output:
 * 9
 * Explanation:
 * Max subarray sum is 9
 * of elements (1, 2, 3, -2, 5) which
 * is a contiguous subarray.
 * */

public  class FIndLargestSumInContiguousSubArray {
    public static void main(String[] args) {
        int arr[]={-1,-4,4,6,8,-2};
        int arr2[]={-1,-2,-3,-4,-5};
        findLargestSumApproach1(arr);
        findLargestSumApproach1(arr2); // that will return 0 that is not the correct answer so need to fix this
        // correct Ans is -1;
        findLargestSumBestApproach(arr2);
        findLargestSumBestApproach(arr);
    }

    private static void findLargestSumApproach1(int[] arr) {
        int current=0;
        int maxSum=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>0){
                current+=arr[i];
                maxSum=Math.max(maxSum,current);
            }
        }
        System.out.println("Largest Sum "+maxSum);
    }

    // used this one always
    private static void findLargestSumBestApproach(int arr[]){
        // int arr[]={-1,-4,4,6,8,-2};
        int current=arr[0];
        int maxSum=current;
        for (int i = 0; i < arr.length; i++) {
            current=Math.max(arr[i],current+arr[i]);
            maxSum=Math.max(maxSum,current);
        }
        System.out.println("Largest sum "+maxSum);
    }
}
