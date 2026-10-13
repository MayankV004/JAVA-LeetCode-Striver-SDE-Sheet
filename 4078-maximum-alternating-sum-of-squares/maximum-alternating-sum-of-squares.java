class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }

        Arrays.sort(arr);

        int len = (n + 1) / 2;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long x = arr[n - 1 - i];
            long square = x * x;

            if (i < len) {
                sum += square;
            } else {
                sum -= square;
            }
        }

        return sum;
    }
}