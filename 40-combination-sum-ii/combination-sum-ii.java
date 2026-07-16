class Solution {
    public void backtracking(int start , int[] candidates, int target , List<List<Integer>> res , List<Integer> temp ){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target < 0) return;

        for(int i = start ; i < candidates.length ; i=i+1 ){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            backtracking(i+1 , candidates , target - candidates[i] , res, temp);
            System.out.println(temp);
            temp.removeLast();
        
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0 , candidates , target , res , new ArrayList<>());

        return res;
    }
}