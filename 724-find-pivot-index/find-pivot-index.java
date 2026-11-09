class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        int suffix[] = new int[n+1];

        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        for(int i = n-2 ; i >= 0 ; i--){
            suffix[i] = suffix[i+1] + nums[i+1]; 
        }

        for(int i = 0 ; i < n ; i++){
            int left = prefix[i];
            int right = suffix[i];

            if(left == right){
                return i;
            }
        }

        return -1;
    }
}