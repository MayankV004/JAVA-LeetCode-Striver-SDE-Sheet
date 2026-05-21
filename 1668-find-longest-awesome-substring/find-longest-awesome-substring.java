class Solution {
    public int longestAwesome(String s) {
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);

        int maxi = 0;
        int cummulativeXor = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            int digit = s.charAt(i) - '0';
            cummulativeXor ^= (1 << digit);
            // for even length
            if(map.containsKey(cummulativeXor)){
                maxi = Math.max(maxi , i - map.get(cummulativeXor));
            }
            // 1 bit difference
            for(int j = 0 ; j <= 9 ; j++){
                int xor = cummulativeXor ^ (1 << j);

                if(map.containsKey(xor)){
                    maxi = Math.max(maxi , i - map.get(xor));
                }

            }
            if(!map.containsKey(cummulativeXor)){
                map.put(cummulativeXor , i);
            }
        }
        return maxi;
    }
}