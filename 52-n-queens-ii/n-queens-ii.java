class Solution {
    int ans = 0;
    public void backtracking(int row ,Set<Integer> cols, Set<Integer> diags , Set<Integer> antiDiags , int n ){
        // base case 
        if(row == n){
            //reached last row sucessfully
            ans = ans + 1;
            return;
        }

        for(int col = 0 ; col < n ; col = col + 1){
            if(cols.contains(col)) continue;

            int diag = col - row;
            if(diags.contains(diag)) continue;

            int antiDiag = col + row;
            if(antiDiags.contains(antiDiag)) continue;

            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            backtracking(row + 1 , cols , diags ,antiDiags , n);

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);

        }
    }
    public int totalNQueens(int n) {
        ans = 0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();

        backtracking(0 , cols , diags ,antiDiags , n);

        return ans;
    }
}