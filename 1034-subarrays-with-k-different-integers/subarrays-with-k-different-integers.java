class Solution {
    private int atmost(int []nums , int k ){
        int i = 0 ; int j = 0 ;
        int ans = 0;
        Map<Integer , Integer> map = new HashMap<>();

        while(j < nums.length){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0)+1);

            while(map.size() > k){
                // shrinking the window
                map.put(nums[i] , map.getOrDefault(nums[i] , 0) - 1); //

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }

            ans += (j - i + 1); // counting subarray till j from i
            j++;
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums , k) - atmost(nums , k-1);
    }

}