class Solution {
    public int maxArea(int[] height) {
        int l = 0 ; int r = height.length -1 ;

        if (height.length <= 1) return 0;
        int highestWater = 0;
        while(l < r){
            int currheight = Math.min(height[l],height[r]);
            int diff = r-l;

            int currWater = currheight * diff;
            highestWater = Math.max(highestWater , currWater);
            System.out.println(highestWater);
            if(height[l] <= height[r]){
                l++;
            } else r--;

        }
        return highestWater;
    }
}