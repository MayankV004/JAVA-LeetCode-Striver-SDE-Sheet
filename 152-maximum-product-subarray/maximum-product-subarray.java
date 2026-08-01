class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 2 DP states

        int []minDP = new int[n];
        int []maxDP = new int[n];

        int ans = nums[0];
        minDP[0] = nums[0];
        maxDP[0] = nums[0];

        for(int i = 1 ; i < n ; i ++){
            int current = nums[i];

            minDP[i] = Math.min(current , Math.min(current * minDP[i-1] , current * maxDP[i-1]));
            maxDP[i] = Math.max(current , Math.max(current * minDP[i-1] , current * maxDP[i-1]));

            ans = Math.max(ans , maxDP[i]);
        }

        return ans;

    }
}