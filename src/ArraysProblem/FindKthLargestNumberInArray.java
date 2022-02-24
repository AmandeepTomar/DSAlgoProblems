package ArraysProblem;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest
 * element in the given array. It is given that all array elements are distinct.
 *
 * Input:
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 7
 * Explanation :
 * 3rd smallest element in the given
 * array is 7.
 * */
public class FindKthLargestNumberInArray {


    public static void main(String[] args) {
        int arr[]=new int[]{1,2,3,4,5,6,7,8};
        int kth=5;
        System.out.println(findKthLargestNumber(arr,kth));

        int arr1[]=new int[]{8,7,6,1,2,3,10,8,2,1,32,10};
        int kth1=3;
        System.out.println(findKthLargestNumber(arr1,kth1));
    }

    static Integer findKthLargestNumber(int[] arr, int kth){
        // by default PriorityQueue is minHeap so if you want to find the kth Maximum remove
        //  PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder()) from Collections.reverseOrder()
        PriorityQueue<Integer> queue=new PriorityQueue<>();

        for (int i=0;i<arr.length;i++){
            queue.add(arr[i]);
            if (queue.size()>kth) {
                queue.poll(); // remove
            }
        }
        return queue.peek(); // fetch
    }
}


