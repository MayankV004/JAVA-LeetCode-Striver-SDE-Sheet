class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> result = new ArrayList<>();
        if(n < m) return result;
        
        int need [] = new int[26];
        for(int i = 0 ; i < m ; i++ ){
            need[p.charAt(i) - 'a']++;
        }

        int window [] = new int[26];
        for(int i = 0 ; i < n ; i++){
            window[s.charAt(i) - 'a']++;

            if(i >= m) window[s.charAt(i-m) - 'a']--;
            if(i >= m-1 && Arrays.equals(need , window)){
                result.add(i - m + 1);
            } 
        }

        return result;

    }
}