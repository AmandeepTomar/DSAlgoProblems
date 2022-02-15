package ArraysProblem;
/**Trailing zeroes in factorial
 Easy Accuracy: 52.7% Submissions: 46501 Points: 2
 For an integer N find the number of trailing zeroes in N!.

 Example 1:

 Input:
 N = 5
 Output:
 1
 Explanation:
 5! = 120 so the number of trailing zero is 1.
 Example 2:

 Input:
 N = 4
 Output:
 0
 Explanation:
 4! = 24 so the number of trailing zero is 0.
 Your Task:
 You don't need to read input or print anything. Your task is to complete the function trailingZeroes() which take an integer N as an input parameter and returns the count of trailing zeroes in the N!.

 Expected Time Complexity: O(logN)
 Expected Auxiliary Space: O(1)

 Constraints:
 1 <= N <= 109
 * */
public class FindTrailingZerosOffactorials {
    public static void main(String[] args) {
        int num=10;
        System.out.println("factorial of "+num+" is ="+calculatefactorial(num));
        int zeros=trailingZerosInFactorial(num);
        System.out.println("No of trailing Zeros "+zeros);

    }

    private static int calculatefactorial(int num) {
        if (num==0 || num==1 || num==2)
        return num;
        else return calculatefactorial(num-1)*num;
    }

    static int trailingZerosInFactorial(int num){
        // its like how much 10
        int result=0;
        int p=5;
        while ((num/p)>0){
            result = result+ num/5;
            p=p*5;
        }
        return result;
    }


}
