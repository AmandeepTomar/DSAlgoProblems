package dynamicproblems;

public class ClimbStairsProblem {
    // climb starirs with three possibility of 3 , 1 ,2 ,3
    // 3 -> 1
    // 3 -> 2
    // 3 -> 3
    public static void main(String[] args) {
        int n = 6;
        int sol1 = solutionWithRecursion(n);
        System.out.println("Sol1 " + sol1);
        int sol2 = solutionWithMemorization(n, new int[n + 1]);
        System.out.println("Sol2 " + sol2);
        int sol3 = solutionWithTabulization(n);
        System.out.println("Sol3 " + sol3);


    }


    private static int solutionWithRecursion(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        int sp1 = solutionWithRecursion(n - 1); // climb 1 stairs at a time
        int sp2 = solutionWithRecursion(n - 2); // climb 2 staairs at a time
        int sp3 = solutionWithRecursion(n - 3); // climb 3 stairs at a time

        int sp = sp1 + sp2 + sp3;
        return sp;
    }

    private static int solutionWithTabulization(int n) {
      int dp[]= new int[n+1];
      dp[0]=1;
      for (int i =1;i<=n;i++){
          if(i==1){
              dp[i]=dp[i-1];
          }else if (i==2){
              dp[i]=dp[i-1] + dp[i-2];
          }else {
              dp[i]=dp[i-1] + dp[i-2] + dp[i-3];
          }
      }

      return dp[n];
    }

    private static int solutionWithMemorization(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (dp[n]!=0){
            return dp[n];
        }
        int sp1 = solutionWithMemorization(n - 1,dp); // climb 1 stairs at a time
        int sp2 = solutionWithMemorization(n - 2,dp); // climb 2 staairs at a time
        int sp3 = solutionWithMemorization(n - 3,dp); // climb 3 stairs at a time

        int sp = sp1 + sp2 + sp3;
        dp[n]=sp;
        return sp;
    }
}
