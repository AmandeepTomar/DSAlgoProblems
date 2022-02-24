package dynamicproblems;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String str="JAVAAID";
        String str2="JAVAID";
//        String str2="AMANDEEP";
//        String str="DEEP";
        int m=str.length();
        int n=str2.length();
        int count=0;


        System.out.println(solution1(str, str2, m, n, count));
        System.out.println(solutionWithDynamicSolution(str, str2));
    }

    private static int solution1(String str, String str2, int m, int n, int count) {
        int count1=0,count2=0,count3=0;
        count1=count;
        if (m<=0||n<=0){
            return count;
        }else if (str.charAt(m-1)==str2.charAt(n-1)){
            count1=solution1(str,str2,m-1,n-1,count+1);
        }else {
            count2 = solution1(str,str2,m,n-1,0);
            count3 = solution1(str,str2,m-1,n,0);
        }
        return Math.max(count1,Math.max(count2,count3));
    }


    private static int solutionWithDynamicSolution(String str,String str2){
        int m=str.length();
        int n=str2.length();
        int result=0;
        int dp[][]=new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i==0||j==0){
                    dp[i][j]=0;
                }else if (str.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    result=Math.max(result,dp[i][j]);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return result;
    }

}
