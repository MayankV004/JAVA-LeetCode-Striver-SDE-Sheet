class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0 ; int j = n-1;
        int points = 0;
        while(i < n && directions.charAt(i) == 'L' ) i++;
        while(j >= 0 && directions.charAt(j) == 'R' ) j--;

        for(int k = i  ; k<= j ; k++)
        {
            char ch = directions.charAt(k);
            if( ch == 'L' || ch == 'R') points ++;
        }

        return points;
    }
}