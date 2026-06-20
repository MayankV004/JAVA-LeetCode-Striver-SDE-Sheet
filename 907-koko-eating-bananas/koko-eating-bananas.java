class Solution {
    public boolean canEatBananas(int k , int []piles , int h){
        int hr = 0;
        for(int pile : piles){
            hr += (pile + k - 1)/k;
            if(hr > h){
                return false;
            }
        }
        return true;
        
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 ; 
        int high = Arrays.stream(piles).max().orElse(1000000000) ;

        while(low < high){
            int mid = low + (high - low)/2;

            if(canEatBananas(mid , piles , h)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}