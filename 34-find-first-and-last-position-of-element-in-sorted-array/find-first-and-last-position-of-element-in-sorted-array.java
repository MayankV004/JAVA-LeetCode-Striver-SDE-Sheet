class Solution {
    public int findFirstOccurance(int n , int nums[] , int target){
        int leftMost = -1;

        int l = 0 , r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                leftMost = mid; // possibly a answer but we will still check in the left side
                r = mid-1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return leftMost;
    }

    public int findLastOccurance(int n , int []nums , int target){
        int rightMost = -1;

        int l = 0 , r = n-1;

        while( l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                rightMost = mid;
                l = mid + 1; // checking on the right side 
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1; 
            }
        }
        return rightMost;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int leftMost = findFirstOccurance(n , nums , target);
        int rightMost = findLastOccurance(n , nums , target);

        return new int[]{leftMost , rightMost};
    }
}