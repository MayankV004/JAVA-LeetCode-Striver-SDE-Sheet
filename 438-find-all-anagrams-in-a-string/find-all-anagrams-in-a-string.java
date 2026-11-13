class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int lenP = p.length();
        char chP[] = p.toCharArray();
        Arrays.sort(chP);
        p = new String(chP); 
        List<Integer> res = new ArrayList<>();
        if(n < lenP){
            return res;
        }
        for(int i = 0 ; i <= n - lenP ; i++ ){
            String  curr = s.substring(i , i + lenP);
            char chCurr[] = curr.toCharArray();
            Arrays.sort(chCurr);
            curr = new String(chCurr);

            if(curr.equals(p) ){
                res.add(i);
            }
        }

        return res;
    }
}