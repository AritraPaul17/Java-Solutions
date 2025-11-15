import java.util.Arrays;

public class Subset {
//    static boolean subset(int[] a,int sum,int n){
//        //base condition
//        if(sum==0 ){
//            return true;
//        }
//        if(n==0)
//            return false;
//
//        //recursive code
//        if(a[n-1]<=sum){
//            return subset(a,sum-a[n-1],n-1) | subset(a,sum,n-1);
//        }
//        else
//            return subset(a,sum,n-1);
//    }

    static boolean subsetUsingDp(int[] a,int sum){
        int n = a.length;
        boolean [][]dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1]<=j){
                    dp[i][j] = dp[i-1][j-a[i-1]] | dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<sum+1;j++){
//                System.out.print(dp[i][j]+"  ");
//            }
//            System.out.println();
//        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int []a = {1,4,5,8};
        int sum = 3;

        System.out.println(subsetUsingDp(a,sum));
    }
}
