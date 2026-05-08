class Solution {
    public int missingNumber(int[] nums) {
        //solution 1
        // Arrays.sort(nums);
        // if(nums[0] != 0 )
        // {
        //     return 0;
        // }
        // int i = 0;
        // for (i = 0 ; i < nums.length - 1; i++)
        // {
        //     if (nums[i] + 1 != nums[i+1] )
        //     {
        //         return nums[i] + 1;
        //     }
            
        // }
        // return nums.length;
        
        // solution 2

        // int count[] = new int[nums.length];
        // for (int i = 0 ; i < nums.length; i++)
        // {
        //     if(nums[i] < nums.length)
        //     {
        //         count[nums[i]] = 1;
        //     }
        // }
        // for(int i = 0 ; i < nums.length ; i++)
        // {
        //     if (count[i] == 0) return i;
        // }
        // return nums.length;

        // solution 3  -> TC: O(n) SC:o(1)
        // xor approach 

        // int n = nums.length;

        // int ans = 0;

        // for(int i = 1 ; i <= n ; i++){
        //     ans = ans ^ i;  // 0 ^ 1 ^ 2 ^ 3
        // }
        // for(int i = 0 ; i < n ; i++){
        //     // 0 ^ 1 ^ 2 ^ 3
        //     // 0 ^ 1 ^ 2 ^ 3 ^ 3 -> 0 ^ 1 ^ 2 ^ 0 -> 1 ^ 2 ^ 1 -> 2 = ans
        //     ans = ans ^ nums[i];  
        // }
        // return ans; 
        

        // solution 4 -> TC: O(n) SC:o(1)

        // expected sum - actual sum approach

        int expectedSum = 0;
        int actualSum = 0;
        for(int num : nums){
            actualSum += num;
        }

        int n = nums.length;

        expectedSum = (n*(n + 1))/2;

        int ans = expectedSum - actualSum;

        return ans;
    }
}