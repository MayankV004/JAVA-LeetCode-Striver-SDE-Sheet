class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0 ;
        int prevCount = 0 ;
        int currentCount = 1;

        for(int i = 1 ; i < s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currentCount ++;
            }else{
                ans += Math.min(currentCount , prevCount);
                prevCount = currentCount ;
                currentCount = 1;
            }

        }
        ans += Math.min(currentCount , prevCount);
        return ans;
    }
}