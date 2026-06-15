class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        if(target > nums[n-1]) return n;
        if(target < nums[0]) return 0;

        int l = 0 , r = n-1;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return l;
    }
}