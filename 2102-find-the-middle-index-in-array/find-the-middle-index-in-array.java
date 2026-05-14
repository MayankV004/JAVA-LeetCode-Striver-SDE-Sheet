class Solution {
    public int findMiddleIndex(int[] nums) {
                //  0   1   2   3    4
        // prefix - 2 , 5 , 4 , 12 , 16;
        // suffix - 16, 14, 11, 12 , 4
        // middle - is 3 
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = nums[0]  ; suffix[n-1] = nums[n-1];
        int i = 1 ; int j = n - 2;

        while ( i < n){
            prefix[i] = prefix[i-1] + nums[i];
            suffix[j] = suffix[j+1] + nums[j];
            i++ ; j--;  
        } 

        for(i = 0 ; i < n ; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        return -1;

    }
}