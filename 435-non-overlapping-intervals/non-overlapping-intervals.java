class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int ans = 0;
        for(int i = 1 ; i < intervals.length ; i++){
            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];

            if(currStart < end){
                ans ++;
            }else{
                end = currEnd;
            }
        }
        return ans;
    }
}