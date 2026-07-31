// class Solution {
//     public int jump(int[] nums) {

//         int jumps = 0;
//         int currentEnd = 0;
//         int farthest = 0;

//         for (int i = 0; i < nums.length - 1; i++) {

//             farthest = Math.max(farthest, i + nums[i]);

//             if (i == currentEnd) {
//                 jumps++;
//                 currentEnd = farthest;
//             }
//         }

//         return jumps;
//     }
// }

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // unreachable
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}