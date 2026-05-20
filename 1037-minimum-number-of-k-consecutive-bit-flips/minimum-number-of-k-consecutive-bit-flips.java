class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flips = 0;
        int flipCount = 0;

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){

            if(i >= k){
                flipCount -= dq.pollFirst();
            }

            if(flipCount % 2 == nums[i]){
                
                if(i+k > n) return -1;

                flipCount++;
                dq.addLast(1);
                flips ++;

            }else{
                dq.addLast(0);
            }
        }

        return flips;
    }
}