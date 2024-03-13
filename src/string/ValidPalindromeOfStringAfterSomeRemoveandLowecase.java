package string;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * <p>
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * <p>
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindromeOfStringAfterSomeRemoveandLowecase {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(str));
    }

    private static boolean isValidPalindrome(String str) {
        boolean isPrime = false;
        str = str.replaceAll(
                "[^a-zA-Z]", "");

        System.out.println(str);
       String newStr= str.toLowerCase();
        System.out.println(newStr);

        return isValidPalindromeCheck(newStr,0,str.length()-1);
    }

    private static boolean isValidPalindromeCheck(String newStr,int start, int end) {
        while (start<end){
            if (newStr.charAt(start)!=newStr.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
