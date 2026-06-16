class Solution {
    private int modifiedBinarySearch(int row[] , int n){
        int l = 0 , r = n-1;

        int leftMost = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(row[mid] < 0){
                leftMost = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return leftMost == -1 ? 0 : n - leftMost ;
    }
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int count = 0;
        for(int []row : grid){
            count += modifiedBinarySearch(row , n);
        }
        return count;
    }
}