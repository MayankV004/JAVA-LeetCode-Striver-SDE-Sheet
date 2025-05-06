class Solution {
    public List<Integer> generateRow(int row)
    {
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for(int i = 1 ; i < row ; i++)
        {
            ans *= (row - i);
            ans /= i;
            res.add(ans); 
        }
        return res;

    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 1 ; i <= numRows ; i++)
        {
           ans.add(generateRow(i));
        }
        return ans;
    }
}