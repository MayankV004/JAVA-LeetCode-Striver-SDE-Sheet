class Solution {
    public boolean subsetSum(int []nums , int target){

        int n = nums.length;

        boolean dp[][] = new boolean [n+1][target + 1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        for(int j = 0 ; j < target ; j++){
            dp[0][j] = false;
        }       

        for( int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= target ; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            
            }
        }

        return dp[n][target] ;  
    }

    public boolean canPartition(int[] nums) {
        // as to do equal partitions the total sum of array should be even then only we can divide it into two 
        // else we cannot 

        int sum = 0 ; ;
        for(int it : nums){
            sum += it;
        }

        if(sum % 2 != 0) return false ;

        return subsetSum(nums , sum / 2);

    }
}