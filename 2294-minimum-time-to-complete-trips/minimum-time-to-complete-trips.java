class Solution {
    public boolean tripsDone(long tripTime, int[] time, int totalTrips) {
        long trips = 0;

        for (int t : time) {
            trips += tripTime / t;

            if (trips >= totalTrips) {
                return true; // prevents unnecessary accumulation
            }
        }

        return false;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = (long) Arrays.stream(time).min().orElse(1) * totalTrips;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (tripsDone(mid, time, totalTrips)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}