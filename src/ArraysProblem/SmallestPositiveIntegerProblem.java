package ArraysProblem;
/**
 * Smallest Positive Integer that can not be represented as Sum
 * Hard Accuracy: 49.71% Submissions: 26245 Points: 8
 * Given an array of size N, find the smallest positive integer value that cannot be represented as sum of some elements from the array.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * array[] = {1, 10, 3, 11, 6, 15}
 * Output:
 * 2
 * Explanation:
 * 2 is the smallest integer value that cannot
 * be represented as sum of elements from the array.
 * Example 2:
 *
 * Input:
 * N = 3
 * array[] = {1, 1, 1}
 * Output:
 * 4
 * Explanation:
 * 1 is present in the array.
 * 2 can be created by combining two 1s.
 * 3 can be created by combining three 1s.
 * 4 is the smallest integer value that cannot be
 * represented as sum of elements from the array.
 *
 * So logic is we check min integer in some like
 * first sort array
 * check if minNo >= currentNo -> add minNoCurrentNo so on.
 * */
public class SmallestPositiveIntegerProblem {

    public static void main(String[] args) {
       long array[] = {1, 10, 3, 11, 6, 15};
       int n=6;
        long array1[] = {1, 1,1,1};
        int n1=4;
        System.out.println(solution(array,n)+" Is Smallest Positive Integer that can not be represented as Sum ");
        System.out.println(solution(array1,n1)+" Is Smallest Positive Integer that can not be represented as Sum ");
    }

    private static long solution(long array[] ,int num) {
        long minNo=1;
        for (long l:array){
            if (minNo>=l){
                minNo=minNo+l;
            }
        }
        return minNo;
    }
}
