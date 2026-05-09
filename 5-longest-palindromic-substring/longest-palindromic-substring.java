class Solution {

    public boolean isPalindrome(String s , int i , int j){
        if(i >= j) return true;

        if(s.charAt(i) == s.charAt(j)) {
            return isPalindrome(s , i+1 , j-1);
        }
        return false;
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int start_idx = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPalindrome(s , i , j)){
                    if(j-i+1 > maxLen){
                        maxLen = j - i + 1;
                        start_idx = i;
                    }
                }
            }
        }

        return s.substring(start_idx , start_idx + maxLen);   
    }
}