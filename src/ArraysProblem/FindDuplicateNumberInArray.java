package ArraysProblem;

import java.util.HashSet;

public class FindDuplicateNumberInArray {
    public static void main(String[] args) {
        int arr[]={1,2,4,5,9,1};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        // time efficient but not memory
        // we need to find a solution with time efficient.
        int duplicate=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                duplicate= num;
                break;
            }else{
                set.add(num);
            }
        }
        return duplicate;
    }

    private static int findDuplicateWithTimeEfficient(int num[]){
        int duplicate=0;
        int counter=0;


        return duplicate;
    }
}
