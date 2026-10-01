class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        int longest = 0;
    
       for(int num : set){
            if(!set.contains(num-1)){
                int current = num ;
                int length = 1;

                while(set.contains(current+1)){
                    current++;
                    length++;
                }

                longest = Math.max(length , longest);
            }
       }

       return longest;
    }
}