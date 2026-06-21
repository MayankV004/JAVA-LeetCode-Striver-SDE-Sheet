class Solution {
    public boolean canPlaceBalls(int force ,int[] position, int m){
        int balls = 1; // placing first ball in the start
        int lastBallPosition = position[0];

        for(int i = 1 ; i < position.length ; i++){
            if(position[i] - lastBallPosition >= force){
                balls ++;
                lastBallPosition = position[i];
            } 
            if(balls >= m ){
                return true;
            }
        }
        return false;
        
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(canPlaceBalls( mid , position , m)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
}