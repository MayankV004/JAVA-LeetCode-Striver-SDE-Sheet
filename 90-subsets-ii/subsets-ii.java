class Solution {
    public void backtracking(int startPoint , List<Integer> path , List<List<Integer>> res , int[]nums){
        res.add(new ArrayList<>(path));

        for(int i = startPoint ; i < nums.length ; i++){
            if(i > startPoint && nums[i] == nums[i-1]){
                continue; // eleminating duplicates
            }

            path.add(nums[i]);
            backtracking(i+1 , path , res , nums);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0 , new ArrayList<>() , res , nums);
        return res;   
    }
}