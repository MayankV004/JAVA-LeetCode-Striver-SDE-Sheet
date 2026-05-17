class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Long, Long> map = new HashMap<>();

        long cummulativeXor = 0;
        map.put(cummulativeXor, 1L);
        long ans = 0;
        for (char ch : word.toCharArray()) {
            long shift = ch - 'a'; // to get shift value
            long value = 1 << shift;

            cummulativeXor = cummulativeXor ^ value;
            // here we check for even stings
            //find if cum_xor came in the past,if yes that means the string between has even number of characters
            if (map.containsKey(cummulativeXor)) {
                ans += map.get(cummulativeXor);
            }
            //one character odd - if Xor each character to cum_xor gives a value present in map 
            //then it means that all the characters in between are even 
            for (char c = 'a'; c <= 'j'; c++) {
                shift = c - 'a';
                long xor = cummulativeXor ^ (1 << shift);

                if (map.containsKey(xor)) {
                    ans += map.get(xor);
                }
            }
            map.put(cummulativeXor, map.getOrDefault(cummulativeXor, 0L) + 1L);
        }
        return ans;
    }
    /*
    ------------------------------------------------------------
    EXPLANATION
    ------------------------------------------------------------
    
    A substring is called wonderful if:
    
    1. All characters appear even number of times
    OR
    2. Only one character appears odd number of times
    
    ------------------------------------------------------------
    BITMASK IDEA
    ------------------------------------------------------------
    
    We use a 10-bit mask because characters are only from 'a' to 'j'.
    
    Bit meaning:
    0 -> parity of 'a'
    1 -> parity of 'b'
    ...
    9 -> parity of 'j'
    
    Bit value:
    0 -> even frequency
    1 -> odd frequency
    
    Example:
    
    mask = 0000000101
    
    This means:
    a -> odd
    b -> even
    c -> odd
    others -> even
    
    ------------------------------------------------------------
    PREFIX XOR OBSERVATION
    ------------------------------------------------------------
    
    If two prefixes have SAME mask:
    
    prefix1_mask == prefix2_mask
    
    then substring between them has all characters even.
    
    Why?
    
    Because parity cancels out.
    
    ------------------------------------------------------------
    ONE ODD CHARACTER CASE
    ------------------------------------------------------------
    
    If two masks differ by ONLY ONE BIT,
    then substring between them has exactly one odd character.
    
    Example:
    
    101010
    101110
    
    Only one bit differs.
    
    So we toggle every bit once and check whether
    that mask existed before.
    
    ------------------------------------------------------------
    TIME COMPLEXITY
    ------------------------------------------------------------
    
    For every character:
    - O(1) normal lookup
    - O(10) checking all toggled masks
    
    Total:
    O(10 * n)
    ≈ O(n)
    
    ------------------------------------------------------------
    SPACE COMPLEXITY
    ------------------------------------------------------------
    
    At most 2^10 masks possible.
    
    O(1024)
    ≈ O(1)
    ------------------------------------------------------------
    */
}