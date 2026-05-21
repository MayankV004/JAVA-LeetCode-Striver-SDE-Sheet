class Solution {

    public int findTheLongestSubstring(String s) {

        Map<Integer, Integer> map = new HashMap<>();

        int cummulativeXor = 0;
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'a') {
                cummulativeXor ^= (1 << 0);
            }
            else if (ch == 'e') {
                cummulativeXor ^= (1 << 1);
            }
            else if (ch == 'i') {
                cummulativeXor ^= (1 << 2);
            }
            else if (ch == 'o') {
                cummulativeXor ^= (1 << 3);
            }
            else if (ch == 'u') {
                cummulativeXor ^= (1 << 4);
            }

            if (!map.containsKey(cummulativeXor)) {
                map.put(cummulativeXor, i);
            }

            maxLen = Math.max(maxLen, i - map.get(cummulativeXor));
        }

        return maxLen;
    }
}

/*
============================== EXPLANATION ==============================

We use Prefix XOR + Bitmasking.

Goal:
Find the longest substring where every vowel appears
even number of times.

=======================================================================

BIT REPRESENTATION

We use 5 bits for 5 vowels:

a -> 00001
e -> 00010
i -> 00100
o -> 01000
u -> 10000

Each bit represents parity:

0 -> vowel frequency is even
1 -> vowel frequency is odd

=======================================================================

MAIN IDEA

Whenever we encounter a vowel,
we toggle its corresponding bit using XOR.

Example:

cummulativeXor ^= (1 << 0)

This toggles 'a' bit.

If bit was:
0 -> becomes 1
1 -> becomes 0

So XOR helps track whether frequency is:
even or odd.

=======================================================================

VERY IMPORTANT OBSERVATION

If two prefixes have same cummulativeXor:

prefixXor[i] == prefixXor[j]

then substring between them has all vowels
appearing even number of times.

Why?

Because same parity cancels out.

=======================================================================

EXAMPLE

Suppose:

cummulativeXor at index 2 = 00101
cummulativeXor at index 8 = 00101

Then substring (3...8) has:

all vowels appearing even number of times.

=======================================================================

WHY HASHMAP?

We store first occurrence of every cummulativeXor.

If same xor appears again:

length = currentIndex - firstOccurrence

Take maximum length.

=======================================================================

WHY map.put(0, -1)?

Initially:

cummulativeXor = 0

Meaning:
all vowels have even frequency.

This helps handle substrings starting from index 0.

Example:

If current index = 4
and cummulativeXor becomes 0

length = 4 - (-1)
       = 5

Correct.

=======================================================================

DRY RUN

s = "eleetminicoworoep"

Initial:

cummulativeXor = 00000
map = {0 -> -1}

----------------------------------------------------------------

i = 0
ch = 'e'

Toggle e bit:

cummulativeXor = 00010

Store:
map[00010] = 0

----------------------------------------------------------------

Later same xor appears again:

cummulativeXor = 00010

This means substring between both indices has
all vowels occurring even number of times.

Update answer.

=======================================================================

TIME COMPLEXITY

O(n)

Each character processed once.

=======================================================================

SPACE COMPLEXITY

At most 32 xor states possible.

2^5 because there are 5 vowels.

S.C = O(1)

=======================================================================
*/