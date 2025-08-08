class Solution {
    private void dfs(int[][] image, int sr, int sc, int color , int [][]visited ,int currentColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || 
            visited[sr][sc] == 1 || image[sr][sc] != currentColor){
            return ;
        }

        visited[sr][sc] = 1;
        image[sr][sc] = color;
        
        dfs(image , sr , sc-1 , color , visited , currentColor);
        dfs(image , sr+1 , sc , color , visited , currentColor);
        dfs(image , sr-1 , sc , color , visited , currentColor);
        dfs(image , sr , sc+1 , color , visited , currentColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        int [][]visited = new int[m][n];
        int currentColor = image[sr][sc];

        dfs(image , sr , sc , color , visited , currentColor);
        
        return image;
    }
}