class Solution {
    public int totalSuccessfullPairs(int spell, int[] potions, long success){
        int ans = -1;

        int low = 0 ; 
        int high = potions.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            long currentSuccess = 1L *spell * potions[mid];

            if(currentSuccess < success){
                low = mid + 1;

            }else{
                high = mid - 1;
                ans = potions.length - mid;
            }
        } 
        return ans == -1 ? 0 : ans ;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int ans[] = new int[spells.length];
        
        for(int i = 0 ; i < spells.length ; i++){
            ans[i] = totalSuccessfullPairs(spells[i] , potions , success);
        }
        return ans;
    }
}