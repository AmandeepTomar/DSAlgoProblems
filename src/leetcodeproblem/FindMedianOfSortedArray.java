package leetcodeproblem;
/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * */
public class FindMedianOfSortedArray {
    public static void main(String[] args) {
        int nums1[]=new int[]{1,3};
        int nums2[]=new int[]{3,4};
        int nums3[]=new int[]{2};
       double medium = findMedianOfSortedArray(nums1,nums2);
        System.out.println("nums1 and nums2 "+medium);
        double medium1=   findMedianOfSortedArray(nums1,nums3);
        System.out.println("nums1 and nums3 "+medium1);
    }

    private static double findMedianOfSortedArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0,j=0,k=0;
        double median;
        int res[]=new int[n1+n2];

        while (i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                res[k++] = nums1[i++];
            }else{
                res[k++]=nums2[j++];
            }
        }

        while (i<n1){
            res[k++]=nums1[i++];
        }
        while (j<n2){
            res[k++]=nums2[j++];
        }

        int mid = res.length/2;
        if ((res.length & 1)!=0){
            median = res[mid];
        }else {
            median = (double)(res[mid-1]+res[mid])/2;
        }

        return median;
    }

}
