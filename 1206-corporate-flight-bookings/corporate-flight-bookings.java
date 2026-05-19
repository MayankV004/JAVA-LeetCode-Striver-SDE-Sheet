class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
       
       int ans[] = new int [n];

       for(int []booking : bookings){
            int start = booking[0];
            int end   = booking[1];
            int value = booking[2];

            ans[start-1] += value;
            if(end < n){
               ans[end] -= value; 
            }
       }
       for(int i = 1 ; i < n ; i++){
         ans[i] += ans[i-1];
       }
       return ans;
       
       // BRUTE FORCE
        // int []ans = new int[n];

        // for(int []booking : bookings){
        //     int first = booking[0]-1;
        //     int last = booking[1]-1;
        //     int seats = booking[2];

        //     for(int i = first ; i <= last; i++){
        //         ans[i] += seats;
        //     }
           
        // }   
        // return ans;
    }
}