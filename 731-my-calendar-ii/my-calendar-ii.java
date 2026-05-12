class MyCalendarTwo {

    List<int[]> bookings ;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        
        // checking for triple booking
        // the concept is to store the overlap of double booking in the overlaps 
        // and check for triple booking from it , if it overlaps with any interval in overlaps 
        // then it is a triple booking

        for(int []interval : overlaps){
            int start = interval[0];
            int end = interval[1];

            if(startTime < end && endTime > start){
               return false;
            }
        }

        // finding and adding double bookings

        for(int []interval : bookings){
            int start = interval[0];
            int end = interval[1];

            if(startTime < end && endTime > start){
                int overlapStart = Math.max(start , startTime);
                int overlapEnd = Math.min(end , endTime);

                overlaps.add(new int[]{overlapStart , overlapEnd});
            }
        }
        // adding current booking
        bookings.add(new int[]{startTime , endTime});

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */