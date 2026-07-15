class Solution {
    public void backtracking(String s , Set<String> set , List<String> res  , int idx, StringBuilder sb){
        if(idx == s.length()){
            res.add(sb.toString());
            return ;
        }

        for(int i = idx ; i < s.length() ; i = i + 1){
            String word = s.substring(idx , i + 1);
            if(set.contains(word)){
                int currentLength = sb.length();

                if(currentLength != 0) sb.append(" ");
                
                sb.append(word);
                backtracking(s , set , res , i+1 , sb);
                sb.setLength(currentLength); // on backtracking restoring the SB of previous length
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(String str : wordDict){
            set.add(str);
        }

        backtracking(s , set , res , 0 , new StringBuilder());
        return res;
    }
}