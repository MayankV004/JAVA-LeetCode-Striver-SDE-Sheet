class Solution {
    public void backtracking(int start , int k , int target , List<List<Integer>> res , List<Integer>temp ){
        if(k==0 && target == 0){
            res.add(new ArrayList<>(temp));
            return ;
        }

        for(int i = start ; i <= 9 ; i++){
            if( i > target) return;

            temp.add(i);
            backtracking(i+1 , k-1 , target - i , res , temp);
            System.out.println(temp);
            temp.removeLast();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(1 , k , n , res , new ArrayList<>());
        return res;
    }
}