class Solution {
    public int findMin(int[] nums) {
        int n = nums.length ;

        int low = 0 ; int high = n-1;

        int ans = 5001;

        while(low <= high){
            int mid = low + (high - low)/2;

            ans = Math.min(ans , nums[mid]);

            if(nums[mid] < nums[high]){
                high = mid - 1;
            }else if (nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high--;
            }
        }

        return ans;


    }
}