class Solution {
    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i = i + 1) {
            for (int j = 0; j < board[0].length; j = j + 1) {
                if (board[i][j] != '.')
                    continue;

                for (char d = '1'; d <= '9'; d++) {
                    if (isValidBoard(board, i, j, d)) {
                        board[i][j] = d;
                        if (backtracking(board) == true)
                            return true;
                        board[i][j] = '.';
                    }

                }
                return false; // when no digit is placed
            }
        }
        return true;
    }

    private boolean isValidBoard(char [][] board , int row , int col , char digit){
        int boxRow = 3 * (row/3) ; int boxCol = 3 * (col/3);
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i] == digit) return false;

            if(board[i][col] == digit) return false;

            if(board[boxRow + i/3][boxCol + i % 3] == digit) return false;
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        backtracking(board);
    }
}