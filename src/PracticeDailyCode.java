import java.util.ArrayDeque;
import java.util.HashMap;import java.util.Map;import java.util.Stack;

public class PracticeDailyCode {

    public static void main(String[] args) {
        String str = "abc";
        String res = "";
        permutation(str, 0, str.length() - 1);

        System.out.println(isParanthesismatching("(())"));

        findSubArray(new int[]{12, 5, 31, 9, 21, 8},6, 29);
    }


    public static long[] nextLargerElement(long[] arr, int n)
    {
        long [] res = new long[n];
        ArrayDeque<Long> stack = new ArrayDeque<>();
        for(int i = 0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.getLast() <= arr[i]){
                stack.removeLast();
            }

            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.getLast();
            }
            stack.addLast(arr[i]);
        }

        return res;
    }

    private static boolean isParanthesismatching(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (isOpening(curr)) {
                System.out.println("here");
                stack.push(curr);
            } else {
                if (stack.isEmpty()) return false;
                else if (!isMatching(stack.peek(), curr)) return false;
                else {
                    char popped = stack.pop();
                    System.out.println(popped);
                }
            }
        }

        System.out.println(stack);
        return stack.isEmpty();
    }


    private static boolean isOpening(char c) {
        return (c == '(') || (c == '{') || (c == '[');
    }

    private static boolean isMatching(char c, char curr) {
        return (c == '(' && curr == ')') || (c == '{' && curr == '}') || (c == '[' && curr == ']');
    }

    private static void permutation(String str, int left, int right) {
        if (left == right) {
            System.out.println(str);
        } else {
            for (int j = left; j <= right; j++) {
                str = swapString(str, left, j);
                permutation(str, left + 1, right);
                str = swapString(str, left, j);
            }
        }
    }


    private static String swapString(String str, int index, int j) {
        char charArr[] = str.toCharArray();
        char temp = charArr[index];
        charArr[index] = charArr[j];
        charArr[j] = temp;
        return String.valueOf(charArr);
    }


   static void findSubArray(int a[], int n, int sum){

        int start = 0;
        int end = 0;
        int currSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i < n ;i++){
            currSum +=a[i];
            if(sum - currSum==0){
                start = 0;
                end = i;
                break;
            }

            if(map.containsKey(currSum-sum)){
                start = map.get(currSum-sum)+1;
                end = i;
                break;
            }

            map.put(currSum,i);

        }

       System.out.println("Start and end "+start+" end "+end);
    }
}
