class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        int diff[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            int v = lights[i];

            if(v > 0){
                int left = Math.max(0 , i - v);
                int right = Math.min(n-1 , i + v);

                diff[left]++;

                if(right+1 < n ){
                    diff[right+1]--;
                }
            }
        } 

        int ans = 0;
        int activeCoverage = 0;
        int notGlowing = 0;

        for(int i = 0 ; i < n ; i++){
            activeCoverage += diff[i];

            if(activeCoverage == 0){
                notGlowing++;
            }else{
                if(notGlowing > 0){
                    ans += (notGlowing + 2)/ 3;
                    notGlowing = 0;
                }
                
            }
        }

        if(notGlowing > 0){
            ans += (notGlowing + 2)/ 3;
        }

        return ans;
    }
}