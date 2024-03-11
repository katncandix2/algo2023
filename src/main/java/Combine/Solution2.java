package Combine;

class Solution2{
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public boolean solveSudokuHelper(char[][] board) {
        for (int i = 0;i<board.length;i++){
            for (int j = 0 ;i<board[0].length;j++){
                //当前未被遍历时
                if (board[i][j] == '.'){
                    for (char tmp = '1';tmp<'9';tmp++){

                        if (isValidSudoku(i,j,tmp,board)){
                            board[i][j] = tmp ;

                            if (solveSudokuHelper(board))
                                return true;
                            board[i][j]= '.';
                        };
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

}