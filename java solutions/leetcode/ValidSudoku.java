public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int [] arr = new int[10];
//        for row
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    int num = Character.getNumericValue(board[i][j]);
                    if(arr[num]!=0){
                        return false;
                    }
                    else{
                        arr[num]++;
                    }
                }
            }
            for (int x=0;x<10;x++){
                arr[x] = 0;
            }
        }
//        for coloumn
        for(int j=0;j<9;j++){
            for(int i=0;i<9;i++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    int num = Character.getNumericValue(board[i][j]);
                    if(arr[num]!=0){
                        return false;
                    }
                    else{
                        arr[num]++;
                    }
                }
            }
            for (int x=0;x<10;x++){
                arr[x] = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char [][]a = {

                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}

        };
        System.out.println(isValidSudoku(a));
    }
}
