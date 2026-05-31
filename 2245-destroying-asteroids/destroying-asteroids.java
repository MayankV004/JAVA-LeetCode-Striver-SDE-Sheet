class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        long currMass = mass;
        Arrays.sort(asteroids);
        for(int i = 0 ; i < n ; i++){
            if(currMass < asteroids[i]){
                return false;
            }

            currMass += asteroids[i];
            asteroids[i] = 0;
        }
        return true;
    }
}