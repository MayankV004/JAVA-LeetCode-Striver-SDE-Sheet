class Solution {
    public boolean canCarryWeight(int possibleWeight ,int[] weights, int days){
        int weight = 0;
        int dayCount = 0;
        for(int it : weights){
            weight += it;
            if(weight > possibleWeight){
                dayCount ++;
                weight = it;
            }
        }
        dayCount++;
        if(dayCount > days)return false;
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        
        int high = 0;
        for(int it : weights){
            high += it;
            low = Math.max(low , it);
        }

        while(low < high){
            int mid = low + (high - low )/2;

            if(canCarryWeight(mid , weights , days)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}