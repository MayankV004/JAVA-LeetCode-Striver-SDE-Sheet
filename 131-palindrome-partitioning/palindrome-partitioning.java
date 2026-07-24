class Solution {
    public void backtracking(String s , int start , List<List<String>> res  , List<String> current){
        if(start == s.length()){
            res.add(new ArrayList<>(current));
            return;
        }

        for(int end = start ; end < s.length() ; end++){
            if(isValidPalindrome(s , start , end)){
                current.add(s.substring(start , end+1));
                backtracking(s , end + 1 , res , current);
                current.removeLast();
            }
        }
    }
    public boolean isValidPalindrome(String s , int start , int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }

        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(s , 0 , res , new ArrayList<String>());
        return res;
    }
}