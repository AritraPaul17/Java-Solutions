import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Problem {

    public static int mySqrt(int x) {
        if(x<=1) return x;
        int r = x/2, l=0, mid = 0;
        while(r>=l){
            mid =  l+(r-l)/2;

            if((long)mid*mid==(long)x){
                return mid;
            } else if ((long)mid*mid>(long)x) {
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }

        return l-1;
    }

    public static int maximum69Number (int num) {
        int n = num;
        int pos=-1;
        for(int i=0;n>0;i++){
            if(n%10==6)
               pos = i;
            n /= 10;
        }
        if(pos==-1)
            return num;
        int val = 3*(int)Math.pow(10,pos);
        return num+val;
    }


    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    r.add(i);
                    c.add(j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(r.contains(i) || c.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
//        System.out.println(mySqrt(100));
//        System.out.println()
        int [][]matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
}
