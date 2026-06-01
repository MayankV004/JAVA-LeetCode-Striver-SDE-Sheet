class Solution {
    public String swap(String str , int i , int j){
        StringBuilder sb = new StringBuilder(str);
        // swapping 
        sb.setCharAt(i , str.charAt(j));
        sb.setCharAt(j , str.charAt(i));

        return sb.toString();
    }

    public int slidingPuzzle(int[][] board) {
        String target = "123450";

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                sb.append(board[i][j]);
            }
        }

        String start = sb.toString();

        // using hashset for visited states
        Set<String> visited = new HashSet<>();
        visited.add(start);

        Queue<String> q = new ArrayDeque<>();
        q.offer(start);

        // all the positions 0 can be swapped to
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },
                { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        
        int res = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                String currentState = q.poll();

                if(currentState.equals(target)){
                    return res;
                }

                int positionOfZero = currentState.indexOf('0');

                for(int dir : dirs[positionOfZero]){
                    // posible next state after swaping
                    String nextState = swap(currentState , positionOfZero , dir);

                    if(visited.contains(nextState)) continue;

                    visited.add(nextState);
                    q.offer(nextState);
                }
            }
            res++;
        }
        return -1;


    }
}