import java.util.Arrays;

public class LCS {
    static int memorization(String s1,String s2,int m,int n,int[][] dp){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return dp[m][n] = 1 + memorization(s1,s2,m-1,n-1,dp);
        }
        else {
            return dp[m][n] = Math.max(memorization(s1,s2,m,n-1,dp), memorization(s1,s2,m-1,n,dp));
        }
    }

    static int topDown(String s1,String s2){
        int m = s1.length(), n = s2.length();
        int [][]dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1 = "abgcefs";
        String s2 = "bgdxfcrs";
        int m = s1.length(), n = s2.length();
        int [][]dp = new int[m+1][n+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(memorization(s1,s2,m,n,dp));
        System.out.println(topDown(s1,s2));
    }
}
