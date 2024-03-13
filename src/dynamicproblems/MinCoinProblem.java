package dynamicproblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinCoinProblem {

    public static void main(String[] args) {
        int n = 18;
        int a[]={7,5,1};

       int ans =  minCoins(n,a);
        System.out.println(ans);

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]= 0;
      int coinsUsingDp  =  minCoinsUsingDp(n, a,dp);
        System.out.println("Coins Using Dp "+coinsUsingDp);
        System.out.println("dp Arrays "+ Arrays.toString(dp));

    }


    static int minCoins(int n , int a[]){
        if (n==0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i =0 ; i<a.length;i++){
            if (n-a[i]>=0){
                int subAns = minCoins(n-a[i],a);
                if (subAns!=Integer.MAX_VALUE && subAns+1<ans){
                    ans = subAns+1;
                }
            }
        }
        return ans;
    }


    static int minCoinsUsingDp(int n , int coinSet[],int dp[]){
        if (n==0) return 0;
        int ans = Integer.MAX_VALUE;

        for (int i =0;i<coinSet.length;i++) {
            if (n - coinSet[i]>=0){
                int subAns = 0;
                if (dp[n-coinSet[i]]!=-1){
                    subAns = dp[n-coinSet[i]];
                }else {
                    subAns = minCoinsUsingDp(n-coinSet[i], coinSet,dp);
                }

                if (subAns != Integer.MAX_VALUE && subAns+1<ans){
                    ans = subAns+1;
                }
            }
        }
        dp[n] = ans;
        System.out.println("dp Arrays+"+n+" - "+Arrays.toString(dp));
        return  ans;
    }
}
