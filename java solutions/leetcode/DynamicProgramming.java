public class DynamicProgramming {


    public static int countSquareMatrix(int [][]a){
        int m = a.length;
        int n = a[0].length;
        int sum = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==1){
                    int down = 0, right = 0, corner = 0;
                    for(int x=i;x<m;x++){
                        if(a[x][j]==0) break;
                        down++;
                    }
                    for(int y=j;y<n;y++){
                        if(a[i][y]==0) break;
                        right++;
                    }
                    for(int x=i,y=j;x<m && y<n;x++,y++){
                        if(a[x][y]==0) break;
                        corner++;
                    }
                    sum += Math.min(down,Math.min(right,corner));
                }

            }
        }
        int ans = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(a[i][j]==1){
                    int up = 0, left = 0, corner = 0;
                    for(int x=i;x>=0;x--){
                        if(a[x][j]==0) break;
                        up++;
                    }
                    for(int y=j;y>=0;y--){
                        if(a[i][y]==0) break;
                        left++;
                    }
                    for(int x=i,y=j;x>=0 && y>=0;x--,y--){
                        if(a[x][y]==0) break;
                        corner++;
                    }
                    ans += Math.min(up,Math.min(left,corner));
                }
            }
        }
        return Math.min(sum,ans);
    }
    public static void main(String[] args) {
        int [][] a = {
                        {1,1,0,0,1},
                        {1,0,1,1,1},
                        {1,1,1,1,1},
                        {1,0,1,0,1},
                        {0,0,1,0,1}
        };
        System.out.println(countSquareMatrix(a));
    }
}
