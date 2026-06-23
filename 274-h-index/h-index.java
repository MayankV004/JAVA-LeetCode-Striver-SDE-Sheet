class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int citation = citations[mid];

            if (citation != 0 && citation > n - mid) {
                ans = Math.max(ans, n - mid);
            }

            if (n - mid >= citation) {
                ans = Math.max(ans, citation);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans == -1 ? n : ans;
    }

}