class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // prefix sum 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0 -> -1, 1 -> +1
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {

                // Same prefix sum => subarray sum is 0
                maxLen = Math.max(maxLen, i - map.get(sum));

            } else {

                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}