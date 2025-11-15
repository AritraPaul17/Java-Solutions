public class RodCutting {

    static  void solve(int []length,int []price ,int len){
        int n = price.length;
        int [][]dp = new int[n+1][len+1];
        //        initialization
        for(int i=0;i<len+1;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
//        main code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<len+1;j++){
                if(length[i-1]<=j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][len]);
    }
    public static void main(String[] args) {
        int []length = {1,2,3};
        int []price = {1,3,4};
        int len = 8;
        solve(length,price,len);
    }
}
