class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i] , i);
        }
        int []ans = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            int remaining = target - curr ;

            if(map.containsKey(remaining) && map.get(remaining) != i){
                ans[0] = i;
                ans[1] = map.get(remaining);
                break;
            }
        }
        return ans;
    }
}