class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        if(nums[0] != nums[1]){
            return nums[0];
        }

        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        int low = 1; 
        int high = n-2;

        while(low <high){
            int mid = low + (high - low)/2;
            boolean isMidEven = mid % 2 == 0 ? true : false;
            if(isMidEven){
                if(nums[mid] != nums[mid + 1]){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] != nums[mid + 1]){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
        }
        return nums[high];
    }
}