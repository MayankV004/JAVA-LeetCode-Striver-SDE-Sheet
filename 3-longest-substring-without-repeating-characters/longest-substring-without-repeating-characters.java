class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[] = new int[256];
        int n = s.length();
        Arrays.fill(hash , -1);

        int l = 0 , r = 0;
        int maxi = 0;
        while (r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            hash[s.charAt(r)] = r;
            int len = r - l + 1;
            maxi = Math.max(maxi , len);
            r++;
        }

        return maxi;
    }
}