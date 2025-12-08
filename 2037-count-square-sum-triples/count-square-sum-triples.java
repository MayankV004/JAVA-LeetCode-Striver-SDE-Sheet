class Solution {

    public int countTriples(int n) {
        int ans = 0;

        //Brute Force
        // for(int i = 1 ; i <= n-2; i++){
        //     for(int j = i+1 ; j <= n-1 ; j++){
        //         for(int k = j+1 ; k <= n ; k++){
        //             if((i*i) + (j*j) == k*k )
        //             {
        //                 ans+=2;   
        //             }
        //         }
        //     }
        // }
        
        // optimised
        for(int i = n ; i> 0 ; i--){
            int left = 1;
            int right = n-1;
            while(left < right){
                if(right * right + left*left > i*i) right--;
                else left++;

                if(right*right + left*left == i*i) ans+=2;
            }

        }
        return ans;
    }

}