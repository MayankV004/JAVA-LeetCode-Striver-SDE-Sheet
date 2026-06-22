class Solution {
    public boolean canBeSplitted(int sum , int[] nums, int k){
        int count = 1;
        int currentSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            currentSum += nums[i];
            
            if(currentSum > sum ){
                count++;
                currentSum = nums[i];
        
            }

            if(count > k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0 ; int high = 0;
        for(int num : nums){
            low = Math.max(low , num);
            high += num;
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high - low )/2;

            if(canBeSplitted(mid , nums , k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}