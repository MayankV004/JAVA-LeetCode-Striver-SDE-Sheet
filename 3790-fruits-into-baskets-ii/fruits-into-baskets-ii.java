class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            boolean placed = false;
            for(int j = 0 ; j < n ; j++){
                if(fruits[i] <= baskets[j]){
                    placed = true;
                    baskets[j] = -1;
                    break;
                }
            }

            if(placed == false){
                ans ++;
            }
        }

        return ans ;
    }
}