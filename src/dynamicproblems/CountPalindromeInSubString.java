package dynamicproblems;

public class CountPalindromeInSubString {

    public static void main(String[] args) {
        String str="abccbc";
        countPalindrome(str);
    }

    private static void countPalindrome(String str) {
        int n=str.length();

        boolean dp[][]=new boolean[n][n];
        int count=0;
        for (int g = 0; g < n ; g++) {

            for (int i = 0 , j=g; j<dp.length ; i++,j++) {
                if (g==0){
                    dp[i][j]=true;
                }else if (g==1){
                    if (str.charAt(i)== str.charAt(j)){
                        dp[i][j]=true;
                    }else {
                        dp[i][j] = false;
                    }
                    }else {
                        if (str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true){
                            dp[i][j]=true;
                        }
                    }
                if (dp[i][j]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
