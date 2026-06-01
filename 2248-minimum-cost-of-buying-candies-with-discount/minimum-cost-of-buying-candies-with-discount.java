class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;

        int totalCost = 0 ;
        Arrays.sort(cost);

        for(int i = n-1 ; i>= 0 ; i -= 3){
            // paid for largest Candy
            totalCost += cost[i];

            if(i-1 >= 0){
                // paid for second candy as well if it exists
                totalCost += cost[i-1];
            }

            // now third will be skipped or became free
        }

        return totalCost;
    }
}