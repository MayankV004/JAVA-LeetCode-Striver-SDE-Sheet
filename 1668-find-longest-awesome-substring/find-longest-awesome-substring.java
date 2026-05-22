class Solution {
    public int longestAwesome(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxi = 0;
        int cummulativeXor = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            // Toggle the bit corresponding to current digit
            cummulativeXor ^= (1 << digit);

            // Case 1:
            // If same mask already existed,
            // then all digits between previous index and current index
            // have even frequency
            if (map.containsKey(cummulativeXor)) {
                maxi = Math.max(maxi, i - map.get(cummulativeXor));
            }

            // Case 2:
            // Try changing exactly one bit
            // This allows exactly one digit to have odd frequency
            for (int j = 0; j <= 9; j++) {

                int xor = cummulativeXor ^ (1 << j);

                if (map.containsKey(xor)) {
                    maxi = Math.max(maxi, i - map.get(xor));
                }
            }

            // Store first occurrence of this mask
            // because earliest index gives maximum length
            if (!map.containsKey(cummulativeXor)) {
                map.put(cummulativeXor, i);
            }
        }

        return maxi;
    }
}

/*
------------------------------------ EXPLANATION ------------------------------------

Idea:
We use Bitmasking + Prefix XOR.

A substring can form a palindrome if:
1. Every digit appears even number of times
OR
2. Only one digit appears odd number of times

-------------------------------------------------------------------------------

Mask Meaning:
We maintain a 10-bit mask because digits are from 0 to 9.

Bit = 0  -> digit frequency is even
Bit = 1  -> digit frequency is odd

Example:
mask = 0010100000

This means:
digit 5 -> odd frequency
digit 7 -> odd frequency
all others -> even frequency

-------------------------------------------------------------------------------

Why Prefix XOR Works?

Suppose:

prefixMask[i] = parity state till index i

Then substring (l+1 to r) parity is:

prefixMask[r] ^ prefixMask[l]

If result:
1. == 0
   -> all digits even

2. has exactly one bit set
   -> only one digit odd

Both are valid palindrome conditions.

-------------------------------------------------------------------------------

Case 1: Same Mask

If current mask already appeared before,
then XOR between them becomes 0.

Meaning:
all digits in that substring have even frequency.

Example:

previous mask = 1010
current  mask = 1010

1010 ^ 1010 = 0000

Valid substring.

-------------------------------------------------------------------------------

Case 2: One Bit Difference

We try toggling every bit from 0 to 9:

currentMask ^ (1 << j)

If such mask existed before,
then substring has exactly one odd digit.

Example:

current mask = 1010
previous mask = 1000

1010 ^ 1000 = 0010

Only one bit differs -> valid palindrome.

-------------------------------------------------------------------------------

Why store first occurrence only?

We need maximum length substring.

Earliest occurrence gives larger length:

currentIndex - earliestIndex

So once a mask is stored,
we never update it.

-------------------------------------------------------------------------------

Time Complexity:
O(N * 10)

For every character,
we check 10 possible masks.

-------------------------------------------------------------------------------

Space Complexity:
O(2^10) = O(1024)

Because only 10 bits are possible.

-------------------------------------------------------------------------------
*/