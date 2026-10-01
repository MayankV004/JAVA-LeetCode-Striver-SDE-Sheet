class Solution {
    public int distance (int x , int y){
        int dist = x*x + y*y;
        return dist;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2] , b[2]));

        for(int []point : points){
            int x = point[0];
            int y = point[1];
            int dist = distance(x,y);
            pq.add(new int[]{x , y ,dist});
        }
        int [][] ans = new int[k][2];
        int i = 0;
        while(k-- > 0){
            int []curr = pq.poll();

            int x = curr[0];
            int y = curr[1];

            ans[i][0] = x;
            ans[i][1] = y;

            i++;
        }

        return ans;

        

        

    }
}