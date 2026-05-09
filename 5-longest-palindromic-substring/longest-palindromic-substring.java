class Solution {

    public boolean isPalindrome(String s , int i , int j , boolean [][]dp){
        if(i >= j) return true;
        if(dp[i][j] != false) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = isPalindrome(s , i+1 , j-1, dp);
        }
        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start_idx = 0;

        // using DP for optimization 

        boolean[][] dp = new boolean[1001][1001];

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPalindrome(s , i , j , dp)){
                    if(j-i+1 > maxLen){
                        maxLen = j - i + 1;
                        start_idx = i;
                    }
                }
            }
        }

        return s.substring(start_idx , start_idx + maxLen);   
    }
}