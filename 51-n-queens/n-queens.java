class Solution {
    public void backtracking(int row , 
        Set<Integer> cols, 
        Set<Integer> diags,  
        Set<Integer> antiDiags, 
        List<List<String>> boards, 
        char [][] gameBoard, 
        int n ){
        
        // Base  Case
        if(row == n){
            // we reached end of board and Got an answer
            List<String> board = new ArrayList<>();
            for(int i = 0 ; i < n ; i = i + 1){
                board.add(new String(gameBoard[i]));
            }
            boards.add(board);
            return ;
        }

        // main part
        for(int col = 0 ; col < n ; col = col + 1){

            // avoiding the postions which are already in the way of other queens
            if(cols.contains(col)){
                continue;
            }

            int diag = col - row;
            if(diags.contains(diag)){
                continue;
            }

            int antiDiag = col + row;
            if(antiDiags.contains(antiDiag)){
                continue;
            }

            // got one position
            gameBoard[row][col] = 'Q';
            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            // now we need to go to next row
            backtracking(row + 1 , cols , diags , antiDiags , boards ,gameBoard , n);

            // now comming back 
            // so we need to remove the col , diag ,antiDiag from there respective sets
            // and also revert the 'Q' -> '.'

            gameBoard[row][col] = '.';

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);

        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();

        Set<Integer> cols      = new HashSet<>();
        Set<Integer> diags     = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();

        char [][] gameBoard = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(gameBoard[i] , '.');
        }

        backtracking(0 , cols , diags , antiDiags , boards , gameBoard , n);

        return boards;
    }
}