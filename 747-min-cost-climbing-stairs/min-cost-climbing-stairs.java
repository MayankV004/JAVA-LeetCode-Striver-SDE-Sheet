class Solution {
    private int dp [];
    public int solve(int cost[] , int n , int idx){
        if(idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];

        int oneStep = cost[idx] + solve(cost , n , idx + 1);
        int twoStep = cost[idx] + solve(cost , n , idx + 2);
        return dp[idx] = Math.min(oneStep , twoStep); 
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[1001];
        Arrays.fill(dp , -1);

        return Math.min(solve(cost , n , 0), solve(cost , n , 1));
    }
}