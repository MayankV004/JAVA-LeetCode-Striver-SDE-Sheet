class Solution {
    private void backtracking(int nums[] , boolean used[] , List<Integer> path , List<List<Integer>> res ){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(used[i] == true) continue ; // already in path list
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums , used , path , res);
            // backtracking
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean []used = new boolean[nums.length];

        backtracking(nums , used , new ArrayList<>() , res);
        return res;   
    }
}