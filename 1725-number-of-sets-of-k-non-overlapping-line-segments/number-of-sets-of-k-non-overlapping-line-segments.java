class Solution {
    int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        // base case 
        // k == 0 ->> 1 such that (i < n)

        int dp[][] = new int[1001][1001];
        for(int i = 0 ; i <= n-1 ; i++){
            dp[0][i] = 1; // Base case filled
        }

        for(int kth = 1 ; kth <= k ; kth ++){
            int prevRow [] = new int[n+1];
            for(int x = n-1 ; x>= 0 ; x--){
                prevRow[x] = (prevRow[x+1] + dp[kth-1][x]) % MOD;
            }

            for(int i = n-1 ; i >= 0 ; i-- ){
                int take = prevRow[i+1];
                int skip = dp[kth][i+1] % MOD;

                dp[kth][i] = (skip + take) % MOD;
            }
        }
        return dp[k][0];

    }
}