class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        // we will use property of xor 
        // x ^ x = 0
        for(int i = 0 ; i < arr.length ; i++){
            int cummulativeXor = 0;
            for(int k = i ; k < arr.length ; k++){
                cummulativeXor = cummulativeXor ^ arr[k];
                if(cummulativeXor == 0) {
                // means a1 ^ a2 ^ a3 ^ a4 = 0
                //        i              k 
                // now we can plxe j at any position in between i and k to form a triplet
                // thats why k - i -> give all possible positions for j -> means for triplet count as well
                    count += (k-i);
                }
            }
        }
        return count; 
    }
}