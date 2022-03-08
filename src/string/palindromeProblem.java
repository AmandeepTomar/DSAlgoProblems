package string;
/**
 *Remove a character from a string to make it a palindrome
 * Difficulty Level : Medium
 * Last Updated : 24 Sep, 2021
 * Given a string, we need to check whether it is possible to make this string a palindrome after removing exactly one character from this.
 *
 * Examples:
 *
 * Input  : str = “abcba”
 * Output : Yes
 * we can remove character ‘c’ to make string palindrome
 *
 * Input  : str = “abcbea”
 * Output : Yes
 * we can remove character ‘e’ to make string palindrome
 *
 * Input : str = “abecbea”
 * It is not possible to make this string palindrome
 * just by removing one character
 * */
public class palindromeProblem {

    public static void main(String[] args) {
        String str="abecbea";
        String str1="abcbea";
        System.out.println(solution(str1)+" char At "+str.charAt(solution(str1)));
    }

    private static int solution(String str) {

        int i=0;
        int j=str.length()-1;
        int index=0;
        while (i<=j){
            if (str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else{
                // this one is incorrect
                // need to check for i+1 and j-1 got both time. sub string
                    if (isPalindrome(str,i+1,j)){
                        return i;
                    }

                    if (isPalindrome(str,i,j-1)){
                        return j;
                    }

            }
        }

        System.out.println(" index value is "+str.charAt(index));
        return -2;
    }

    private static boolean isPalindrome(String str,int start, int end){
        while (start<end){
            if (str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
