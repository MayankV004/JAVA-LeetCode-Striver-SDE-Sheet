class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long , Long> map = new HashMap<>();
        
        long cummulativeXor = 0;
        map.put(cummulativeXor , 1L);
        long ans = 0;
        for(char ch : word.toCharArray()){
            long shift = ch - 'a'; // to get shift value
            long value = 1 << shift;

            cummulativeXor = cummulativeXor ^ value;
            if(map.containsKey(cummulativeXor)){
                ans += map.get(cummulativeXor);
            }

            for(char c = 'a' ; c <= 'j' ; c++){
                shift = c - 'a';
                long xor = cummulativeXor ^ (1 << shift);

                if(map.containsKey(xor)){
                    ans += map.get(xor);
                }
            }
            map.put(cummulativeXor , map.getOrDefault(cummulativeXor , 0L) + 1L);
        }
        return ans;   
    }
}