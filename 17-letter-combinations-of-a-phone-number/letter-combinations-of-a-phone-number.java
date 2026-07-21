class Solution {
    private final String[] letters = {"" , "" , "abc" , "def" , "ghi" , "jkl", "mno" , "pqrs" , "tuv" , "wxyz"};

    public void backtracking(char []digits , List<String> res , StringBuilder sb , int idx ){
        if(idx >= digits.length){
            res.add(sb.toString());
            return;
        }
        
        String str = letters[digits[idx] - '0'];

        for(int i = 0 ; i < str.length() ; i++){
            sb.append(str.charAt(i));
            backtracking(digits , res , sb , idx + 1);
            System.out.println(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
        }


        
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        backtracking(digits.toCharArray() , res , new StringBuilder() , 0);

        return res;
    }
}