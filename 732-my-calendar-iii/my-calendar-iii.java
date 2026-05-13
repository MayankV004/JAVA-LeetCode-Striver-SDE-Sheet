class MyCalendarThree {

    // Difference map: stores net change in overlap count at each time point
    // key   = time point (auto-sorted by TreeMap)
    // value = +1 if an event starts here, -1 if an event ends here
    //         (multiple events at the same point accumulate, e.g. +2, -3)
    private Map<Integer, Integer> diff;

    public MyCalendarThree() {
        diff = new TreeMap<>(); // TreeMap ensures time points are processed left → right
    }

    public int book(int startTime, int endTime) {

        // Event becomes active at startTime → increment overlap count at this point
        diff.put(startTime, diff.getOrDefault(startTime, 0) + 1);

        // Event stops being active at endTime → decrement overlap count
        // endTime is exclusive [startTime, endTime), so the event is NOT active at endTime
        diff.put(endTime, diff.getOrDefault(endTime, 0) - 1);

        int maxK    = 0; // tracks the peak overlap seen across the entire timeline
        int currentK = 0; // running overlap count as we sweep left → right

        // Line sweep: walk through all recorded time points in sorted order
        for (int value : diff.values()) {
            currentK += value;              // apply the change: +1 (start) or -1 (end)
            maxK = Math.max(maxK, currentK); // freeze the peak if this is the busiest point so far
        }

        // maxK = maximum number of events overlapping at any single instant
        return maxK;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */