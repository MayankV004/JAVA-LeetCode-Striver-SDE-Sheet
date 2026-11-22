class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return -1;
        }

        final int V = 2100;
        final int INF = 1_000_000_000;

        int [][] inc = new int[n][V+1];
        int [][] dec = new int[n][V+1];

        for(int v = 1 ; v <= V ; v++){
            inc[0][v] = Math.abs(nums[0] - v);
        }
        for(int i = 1 ; i < n ; i++){
            int pm = INF;
            for(int v = 1 ; v <= V ; v++){
                if(v - 1 >= 1 ){
                    pm = Math.min(pm , inc[i-1][v-1]);
                }
                inc[i][v] = (pm >= INF) ? INF : pm + Math.abs(nums[i] - v);
            }
        }

        for(int v = 1 ; v <= V ; v++){
            dec[n-1][v] = Math.abs(nums[n-1] - v);
        }
        for(int i = n-2  ; i >= 0 ; i--){
            int pm = INF;
            for(int v = 1 ; v <= V ; v++){
                if(v - 1 >= 1 ){
                    pm = Math.min(pm , dec[i+1][v-1]);
                }
                dec[i][v] = (pm >= INF) ? INF : pm + Math.abs(nums[i] - v);
            }
        }
        long best = Long.MAX_VALUE;
        for(int p = 1 ; p <= n - 2 ; p++){
            for(int v = 1 ; v <= V ; v++){
                if(inc[p][v] >= INF || dec[p][v] >= INF) continue;
                long cost = (long)inc[p][v] + dec[p][v] - Math.abs(nums[p] - v);
                best = Math.min(best , cost);
                }
        }
        return best==Long.MAX_VALUE?-1:(int)best;
    }
}