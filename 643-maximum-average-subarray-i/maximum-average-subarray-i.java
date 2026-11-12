
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum += nums[i];       // Add incoming element
            sum -= nums[i - k];   // Remove outgoing element

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}
