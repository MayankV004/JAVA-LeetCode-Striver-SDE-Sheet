class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        Set<Character>[] rows = new HashSet[n]; 
        Set<Character>[] cols = new HashSet[n]; 
        Set<Character>[] boxes = new HashSet[n];

        for(int i = 0 ; i < n ; i ++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int row = 0 ; row < board.length ; row++){
            for(int col = 0 ; col < board[0].length ; col++){
                char cell = board[row][col];
                
                if(cell == '.') continue;

                if(rows[row].contains(cell)) return false;
                rows[row].add(cell);

                if(cols[col].contains(cell)) return false;
                cols[col].add(cell);

                int boxIdx = 3 * (row/3) + (col/3);
                
                if(boxes[boxIdx].contains(cell)) return false;
                boxes[boxIdx].add(cell);
            }
        }

        return true;



    }
}