public class RotateImage {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int [][]a = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                a[i][j] = matrix[len-j-1][i];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                matrix[i][j] = a[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int [][]a = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(a);
        System.out.println(a[0][0]);
    }
}
