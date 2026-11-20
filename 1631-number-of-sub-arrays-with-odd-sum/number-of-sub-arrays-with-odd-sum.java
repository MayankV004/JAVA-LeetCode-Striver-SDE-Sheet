class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;

        int even = 1;
        int odd = 0;
        int prefix = 0;
        long ans = 0;

        for(int it : arr){
            prefix += it;

            prefix %= 2;

            if(prefix == 1){
                ans += even;
                odd++;
            }else{
                ans += odd;
                even++;
            }
            ans %= MOD;
        }

        return (int)ans;
    }
}