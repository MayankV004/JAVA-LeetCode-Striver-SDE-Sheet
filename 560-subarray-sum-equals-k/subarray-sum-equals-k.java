class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //  prefixsum , frequency
        int currentSum = 0;
        int ans = 0;

        map.put(0,1);

        for(int it : nums){
            currentSum += it;

            if(map.containsKey(currentSum - k)){
                ans += map.get(currentSum - k ); // count of that particular prefix sum
            }

            map.put(currentSum , map.getOrDefault(currentSum , 0)+1); // storing in the map 

            // basically we are using the prefix sum and map simultaniously 
        }
        return ans;
    }
}