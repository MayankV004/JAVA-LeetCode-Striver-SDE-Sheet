class Solution {
    public int findMinArrowShots(int[][] points) {

        // Sort balloons by their END position (greedy: tackle the earliest-closing
        // balloon first, since it's hardest to include in a future arrow's range)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // Fire the first arrow at the end of the first balloon (optimal position
        // to maximise overlap with subsequent balloons)
        int end   = points[0][1];
        int count = 1;

        // Start from index 1 since index 0 is already covered by the first arrow
        for (int i = 1; i < points.length; i++) {
            int currStart = points[i][0];
            int currEnd   = points[i][1];

            if (currStart <= end) {
                // Current balloon OVERLAPS with the active arrow window.
                // Shrink the window to the intersection (Math.min) so the arrow
                // position remains valid for ALL balloons in this group.
                // We do NOT need Math.max here — since we sorted by end,
                // currEnd is always >= previous end, so Math.min just keeps `end`.
                end = Math.min(currEnd, end);
            } else {
                // Current balloon starts AFTER the active window ends — no overlap.
                // The previous group is fully handled; fire a new arrow at the
                // end of this balloon and start a fresh window.
                end = currEnd;
                count++;
            }
        }

        return count;
    }
}