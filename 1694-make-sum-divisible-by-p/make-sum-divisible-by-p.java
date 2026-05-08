class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0 ; i < n ; i++){
            totalSum = (totalSum + nums[i])%p;
        }

        int target = totalSum % p;

        if(target == 0) return 0;

        int curr = 0;
        int result = n;
        Map<Integer , Integer > map = new HashMap<>();
        map.put(0, -1);

        for(int j = 0 ; j < n ; j++){
            curr = (curr + nums[j])%p;

            int remainder = (curr - target + p) % p;

            if(map.containsKey(remainder)){
                result = Math.min(result , j- map.get(remainder));
            }
            map.put(curr, j);

        }

        return result == n? -1 : result;
    }
}