class Solution {
    public void backtracking(char []ch , List<String> res , int idx ){
        if(idx == ch.length){
            res.add(new String(ch));
            return;
        }

        if(Character.isDigit(ch[idx])){ // skipping for the digit
            backtracking(ch , res , idx + 1);
            return ;
        }

        // for lowercase
        ch[idx] = Character.toLowerCase(ch[idx]);
        backtracking(ch , res , idx + 1);
        
        // for uppercase
        ch[idx] = Character.toUpperCase(ch[idx]);
        backtracking(ch , res , idx + 1);


    }
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtracking(s.toCharArray() , res , 0 );
        return res;
    }
}