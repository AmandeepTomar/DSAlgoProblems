package recursion;


import java.util.ArrayList;
import java.util.List;

/**
 * Algo:
 * check base case
 * if(index ==n-1){
 * list of list m ek sublist add karni hai.
 * jo nums ka array hai uske had element ko add kar sublist m or sublist ko list of list m add kar kr do.
 * }
 * task start hoto hai
 * for loop chalo index se n tak swap ka
 * swap(nums,i , index)
 * recursivecall()
 * // backtracking
 * swap(nums,i,index)
 */
public class Permutation_Problem {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        solutionPermutation(nums, 0, res);
        System.out.println("Result is " + res);

        List<List<String>> stringRes = new ArrayList<>();
        String s ="abc";
        findStringPermutations(s,0,stringRes);
        System.out.println("Result for string is "+stringRes);
    }

    private static void solutionPermutation(int[] nums, int index, List<List<Integer>> res) {
        int n = nums.length;
        if (index == n - 1) {
            List<Integer> subList = new ArrayList<>();
            for (int element : nums) {
                subList.add(element);
            }
            res.add(new ArrayList<>(subList));
        }
        // task
        for (int i = index; i < n; i++) {
            swapNo(nums, i, index);
            solutionPermutation(nums, index + 1, res);
            swapNo(nums, i, index);
        }
    }


    private static void findStringPermutations(String s, int index, List<List<String>> res) {
        int n = s.length();
        if (n == index) {
            List<String> subList = new ArrayList<>();
            for (char ch : s.toCharArray()) {
                subList.add(ch + "");
            }
            res.add(new ArrayList<>(subList));
        }
        // task
        for (int i = index; i < n; i++) {
            swapString(s.toCharArray(), index, i);
            findStringPermutations(s, index + 1, res);
            swapString(s.toCharArray(),index,i);
        }
    }

    private static void swapString(char[] charArray, int index, int i) {
        char ch = charArray[i];
        charArray[i] = charArray[index];
        charArray[index] = ch;
    }

    private static void swapNo(int[] num, int i, int index) {
        int temp = num[i];
        num[i] = num[index];
        num[index] = temp;
    }


}
