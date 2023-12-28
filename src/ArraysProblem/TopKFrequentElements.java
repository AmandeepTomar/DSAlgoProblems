package ArraysProblem;

import java.util.*;

/***
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * */
public class TopKFrequentElements {

    public static void main(String[] args) {

        int arr[]=new int[]{4,1,-1,2,-1,2,3};
        int arr1[]=new int[]{1,1,1,2,2,3};
        int arr2[]=new int[]{1,2};
        int k = 2;
        findtheTopKFrequentElemnts(arr,k);
    }

    private static int[] findtheTopKFrequentElemnts(int[] nums, int k) {

        HashMap<Integer,Integer>map=new LinkedHashMap<>();
        ArrayList<Integer>a=new ArrayList<>();
        int arr[]=new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer>e:map.entrySet()){
            a.add(e.getValue());
        }

        Collections.sort(a);

        int j=a.size()-1;
        for(int i=0;i<arr.length;i++){
            for(Map.Entry<Integer,Integer>e:map.entrySet()){
                if(a.get(j)==e.getValue()){
                    arr[i]=e.getKey();
                    map.remove(e.getKey());
                    j--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
