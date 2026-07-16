class Solution {
    public void backtracking(int start , int[] candidates, int target ,List<List<Integer>> res , List<Integer> temp ){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) return;

        for(int i = start ; i < candidates.length ; i++){
            temp.add(candidates[i]);
            backtracking(i , candidates , target - candidates[i] , res , temp);
            System.out.println(temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(0 ,candidates , target , res , new ArrayList<>());
        return res;
    }
}