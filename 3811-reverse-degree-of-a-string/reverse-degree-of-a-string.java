class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        int idx = 1;
        for(char ch : s.toCharArray()){
            int val = ('z' - ch) + 1;
            ans += (idx * val);
            idx++;
        }

        return ans;
    }
}