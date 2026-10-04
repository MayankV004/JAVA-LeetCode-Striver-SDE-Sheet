class Solution {
    public int singleNumber(int[] nums) {

        int res = 0 ;

        for(int bit = 0 ; bit <= 31 ; bit++){
            int countZeros = 0;
            int countOnes  = 0 ;
            int mask = (1 << bit);
            for(int num : nums){
                if((num & mask) != 0 ){
                    countOnes++;
                }else{
                    countZeros++;
                }
            }

            if(countOnes % 3 == 1){
                res = (res | (1 << bit));
            }
        }    
        return res;
    
    }
}