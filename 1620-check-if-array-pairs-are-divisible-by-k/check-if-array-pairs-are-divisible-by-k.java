// Solution using Array instead of MAP 
class Solution {

    public boolean canArrange(int[] arr, int k) {

        int[] freq = new int[k];

        for (int num : arr) {

            int rem = ((num % k) + k) % k;

            freq[rem]++;
        }

        // Case 1 : remainder 0 must have even frequency
        if (freq[0] % 2 != 0) {
            return false;
        }

        for (int rem = 1; rem < k; rem++) {

            // Case 2 : remainder k/2 when k is even
            if (2 * rem == k) {

                if (freq[rem] % 2 != 0) {
                    return false;
                }
            }

            // Normal case
            else {

                if (freq[rem] != freq[k - rem]) {
                    return false;
                }
            }
        }

        return true;
    }
}

// solution using MAP
// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         Map<Integer , Integer> map = new HashMap<>();

//         for(int it : arr){
//             int rem = ((it % k) + k ) % k;
//             map.merge(rem, 1 , Integer::sum);
//         }
//         int result = 0;
//         for( int rem : map.keySet()){
//             int remainderFreq = map.get(rem);

//             // case 1 : for remainder = 0 , zero hamesha zero ke saath pair karega 
//             if(rem == 0){
//                 if(remainderFreq % 2 != 0) return false;
//             }

//             // case 2 : for when rem = k - rem -> 2rem = k -> then isme bhi do same rem ek saath pair karega
//             // eg = k = 6  -> rem = 3 
//             // so  3 need 3 to make it divisible by 6 as a pair 
//             else if(2*rem == k){
//                 if(remainderFreq % 2 != 0) return false;
//             }
//             // case 3 : normal case -> find k - rem for rem 
//             else{
//                 int otherRemainderFreq = map.getOrDefault(k-rem , 0);
//                 // since the rem can only pair with k - rem 
//                 // so there frequencies should also need to be same to make pairs
//                 // otherwise pairs wont form 
//                 if(remainderFreq != otherRemainderFreq) return false;
//             }
//         }
//         return true;
//     }
// }
/*
============================== EXPLANATION ==============================

Instead of HashMap, we use an array:

freq[i] = frequency of remainder i

Because possible remainders are always:

0 to k-1

So array works perfectly.

-----------------------------------------------------------------------

STEP 1

Store frequencies of remainders.

remainder = ((num % k) + k) % k

This handles negative numbers properly.

Example:
-1 % 5 = -1 in Java

Normalized:
((-1 % 5) + 5) % 5
= 4

-----------------------------------------------------------------------

PAIRING RULE

If one number has remainder:

r

Then it needs:

k-r

because:

r + (k-r) = k

which is divisible by k.

-----------------------------------------------------------------------

CASE 1

remainder = 0

0 pairs with 0 itself.

So frequency must be even.

-----------------------------------------------------------------------

CASE 2

remainder = k/2

Only when k is even.

Example:
k = 8

4 + 4 = 8

So frequency must be even.

-----------------------------------------------------------------------

NORMAL CASE

freq[r] must equal freq[k-r]

Otherwise some elements remain unpaired.

=======================================================================

DRY RUN

arr = [1,2,3,4,5,10,6,7,8,9]
k = 5

Remainders:

1 -> 2
2 -> 2
3 -> 2
4 -> 2
0 -> 2

Check:

1 pairs with 4
2 pairs with 3
0 pairs with 0

All conditions satisfied.

Answer = true

=======================================================================

TIME COMPLEXITY

O(n + k)

O(n) for building frequency array
O(k) for checking pair conditions

=======================================================================

SPACE COMPLEXITY

Frequency array of size k

S.C = O(k)

=======================================================================
*/
