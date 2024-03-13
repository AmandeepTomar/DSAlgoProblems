package binarysearch;

public class BinarySearchToFindFirstAndLastOccurenceOfANo {

    public static void main(String[] args) {

        int arr[]= {2,2,3,4,4,4,6,8,9,10,11};
        int target = 4;
        boolean isFirst = true;
        boolean isLast = true;

        binarySearchSolution(arr, target,isFirst);
    }

    private static void binarySearchSolution(int[] arr, int target, boolean isFirst) {
        int low = 0;
        int end = arr.length-1;
        int ans = -1;

        while(low<=end){
            int mid = low +(end - low)/2;
            if(arr[mid]==target){
                System.out.println(mid);
                ans = mid;
                if(isFirst){
                    end = mid-1;
                }else{
                    low = mid + 1;
                }
            }else if (arr[mid]<target){
                end = mid-1;
            }else {
               low = mid -1;
            }
        }

        if(ans==-1){
            System.out.println("target element "+target+" No present");
        }else{
            System.out.println("target element "+target +" Find at position "+ans);
        }
    }
}
