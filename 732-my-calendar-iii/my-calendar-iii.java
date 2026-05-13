class MyCalendarThree {
    private Map<Integer , Integer> diff ;
    public MyCalendarThree() {
        diff = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        
        diff.put(startTime , diff.getOrDefault(startTime , 0) + 1);
        diff.put(endTime , diff.getOrDefault(endTime , 0) - 1);

        int maxK = 0;
        int currentK = 0;

        for(int value : diff.values()){
            currentK += value;
            maxK = Math.max(maxK , currentK);
        }
        return maxK;
    }

}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */