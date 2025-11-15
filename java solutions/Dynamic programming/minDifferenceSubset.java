public class minDifferenceSubset {
    static int solve(int[] nums,int sum){
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<sum+1;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = Math.max(nums[i-1]+dp[i-1][j-nums[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int []nums = {1,6,11,5};
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        int x = solve(nums,sum/2);
        int y = sum - x;
        int minDiff = Math.abs(x-y);
        System.out.println(x);
        System.out.println(y);
        System.out.println(minDiff);
    }
}
