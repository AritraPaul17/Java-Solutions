import java.util.Arrays;

public class Knapsack {

//    using memorization
    static int solve(int[] wt,int[] val,int m,int n,int[][] dp){
        //base condition
        if(m==0 || n==0){
            return 0;
        }
        //recursive code
        if(dp[n][m]!=-1) return dp[n][m];
        if(wt[n-1]<=m){
            return dp[n][m] = Math.max(val[n-1] + solve(wt,val,m-wt[n-1],n-1,dp) , solve(wt,val,m,n-1,dp));
        }
        else{
            return dp[n][m] = solve(wt,val,m,n-1,dp);
        }
    }
//    static int maxProfit(int[] wt,int[] val,int m){
//        int n = wt.length;
//        int[][] dp= new int[n+1][m+1];
//        for(int i=0;i<n+1;i++)
//                Arrays.fill(dp[i],-1);
//        return solve(wt,val,m,n,dp);
//    }


//    using top-down
    static int maxProfit(int[] wt,int[] val,int m){
        int n = wt.length;
        int[][] dp= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]] , dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int []wt = {1,4,5,8};
        int []val = {2,5,4,7};
        int m = 10;
        System.out.println(maxProfit(wt,val,m));
    }
}
