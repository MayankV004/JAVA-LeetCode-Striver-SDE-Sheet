class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // left half sorted
            else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // right half sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
// class Solution {
//     public int findPivotWithDuplicates(int nums[] ){
//         int low = 0 ; int high = nums.length - 1;

//         while(low < high){
//             // skipping the duplicates from left and right
//             while(low < high && nums[low] == nums[low+1]){
//                 low++;
//             }

//             while(low < high && nums[high] == nums[high-1]){
//                 high --;
//             }

//             int mid = low + (high - low) / 2;

//             if(nums[mid] > nums[high]){
//                 low = mid + 1;
//             }else{
//                 high = mid;
//             }
//         }
//         return high;
//     }

//     public boolean binarySearch(int nums[] , int target , int low , int high){

//         while(low <= high){
//             int mid = low + (high - low)/2;

//             if(nums[mid] == target){
//                 return true;
//             }
//             if(nums[mid] < target){
//                 low = mid + 1;
//             }else{
//                 high = mid - 1;
//             }
//         }
//         return false;
//     }
//     public boolean search(int[] nums, int target) {
       
//         int pivot = findPivotWithDuplicates(nums);
//         System.out.println(pivot);
//         return binarySearch(nums , target , 0 , pivot-1) || binarySearch(nums, target , pivot , nums.length-1);
//     }
// }

