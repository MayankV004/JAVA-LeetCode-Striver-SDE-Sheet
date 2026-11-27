class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int need[] = new int[26];
        int window[] = new int[26];

        for(int i = 0 ; i < n ; i++){
            char ch = s1.charAt(i);
            need[ch - 'a']++;
        }
        for(int i = 0 ; i < m ; i++){
            window[s2.charAt(i) - 'a']++;
            if( i >= n) window[s2.charAt(i-n) - 'a']--;
            if( i >= n-1 && Arrays.equals(need , window)){
                return true;
            }

        }
        return false;
    }
}