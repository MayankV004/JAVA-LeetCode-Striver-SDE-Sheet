class Solution {
    Map<Integer , Integer> map = new HashMap<>();
    int dp[];
    public int solve(int n){
        if(n== 0){
            return dp[n] = 0;
        }
        if(n == 1) {
            return dp[n] = map.getOrDefault(1 , 0);
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = Math.max(map.getOrDefault(n , 0) + solve(n-2) , solve(n-1));
    }
    public int deleteAndEarn(int[] nums) {
        // the recurrence relatetion we will use here is 
        // f(n) = Max(gain + f(n-2) , f(n-1));
        // and we will start from max n;

        int n = nums.length;

        int max = 0;
        for(int num : nums){
            max = Math.max(max , num);
            map.put(num , map.getOrDefault(num , 0) + num);
        }
        dp = new int[max+1];
        Arrays.fill(dp , -1);
        return solve(max);
        


    }
}