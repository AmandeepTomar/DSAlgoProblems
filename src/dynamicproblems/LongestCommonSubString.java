package dynamicproblems;

import java.util.Arrays;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String str="JAVAAID";
        String str2="JAVAID";
//        String str="AMANDEEP";
//        String str2="DEEP";
        int m=str.length();
        int n=str2.length();
        int count=0;

//
//        System.out.println(solution1(str, str2, m, n, count));
//        System.out.println(solutionWithDynamicSolution(str, str2));

// Updated Sheet
        // using dp array
        int [][] dp = new int[m+1][n+1];

        Arrays.fill(dp[0],-1);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {
                dp[i][j] = -1;
            }
        }


       int ans =  lcsUtils(m,n,str,str2,dp);
        System.out.println("LcsUtils Ans "+ans);

    }


    private static int lcsUtils(int m , int n , String a ,  String b , int [][]dp){
        if (m==0 || n==0) return 0;
        if (dp[m][n]!=-1){
            return dp[m][n];
        }
        if (a.charAt(m-1) == b.charAt(n-1)){
            return  dp[m][n] = 1+lcsUtils(m-1,n-1,a,b,dp);
        }else {
            return dp[m][n] = Math.max(lcsUtils(m-1,n,a,b,dp),lcsUtils(m,n-1,a,b,dp));
        }
    }


}
