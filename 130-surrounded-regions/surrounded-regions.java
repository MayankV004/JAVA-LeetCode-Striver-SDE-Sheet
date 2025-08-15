class Solution {

    private void dfs(int row,int col, char [][]board , int [][]notConvert, int m , int n ){
        
        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] == 'X' || notConvert[row][col] == 1){
            return ;
        }

        notConvert[row][col] = 1;
        dfs(row , col-1, board , notConvert , m , n);
        dfs(row , col+1, board , notConvert , m , n);
        dfs(row-1 , col, board , notConvert , m , n);
        dfs(row+1 , col, board , notConvert , m , n);

    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int notConvert[][] =  new int[m][n];
        for(int i = 0 ; i < m ; i++){ // first and last row
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    if(notConvert[i][j] == 0 && board[i][j] == 'O'){
                        dfs(i , j , board , notConvert, m , n);
                    }
                }

            }
        }

        // now changning in the Board Grid 

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'O' && notConvert[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
