class Solution {
    public void backtracking(int start , int n , int k , List<Integer>temp , List<List<Integer>> res){
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start ; i <= n ; i=i+1 ){
            temp.add(i);
            backtracking(i+1 , n , k-1 ,temp , res);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(1 , n , k , new ArrayList<>() , res);
        return res;
    }
}