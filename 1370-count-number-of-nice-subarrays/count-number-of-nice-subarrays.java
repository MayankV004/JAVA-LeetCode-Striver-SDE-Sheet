class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // convert odd -> 1 ; even -> 0
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }else{
                nums[i] = 1;
            }
        }

        // apply subarray sum = k;

        Map<Integer , Integer> map = new HashMap<>();

        map.put(0,1); // base case

        int currSum = 0 ;
        int ans = 0;

        for(int it : nums){
            currSum += it;

            int target = currSum - k;

            if(map.containsKey(target)){
                ans += map.get(target);
            }
            map.put(currSum , map.getOrDefault(currSum , 0) + 1);

        }
        return ans;

    }
}