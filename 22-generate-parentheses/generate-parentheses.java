class Solution {
    public void backtracking(List<String> res , StringBuilder path , int n , int open , int close ){
        if(path.length() == 2 * n){
            // got our ans
            res.add(path.toString());
            return ;
        }
        
        // safety check
        if(open < n){
            path.append("("); // do 
            backtracking(res , path , n , open + 1 , close); // explore
            path.deleteCharAt(path.length() - 1); // undo
        }
        // Safety check
        if(close < open){ // still the string is valid
            path.append(")"); // do 
            backtracking(res , path , n , open , close + 1);   // explore
            path.deleteCharAt(path.length() - 1); // undo
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res , new StringBuilder() , n , 0 , 0 );
        return res;
    }
}