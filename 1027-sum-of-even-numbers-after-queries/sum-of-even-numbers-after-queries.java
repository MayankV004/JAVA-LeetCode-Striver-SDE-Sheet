class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int sum = 0;

        // Initial sum of all even numbers
        for (int num : nums) {
            if (num % 2 == 0)
                sum += num;
        }

        int ans[] = new int[queries.length];

        int i = 0;

        for (int[] query : queries) {

            int value = query[0];
            int idx = query[1];

            // Check whether old value is even or odd
            boolean oldNumValue = nums[idx] % 2 == 0;

            // ---------------- ODD CASE ----------------
            if (!oldNumValue) {

                // Update the number
                nums[idx] = nums[idx] + value;

                // CASE 1 : odd -> even
                // Add new even value into sum
                if (nums[idx] % 2 == 0) {
                    sum += nums[idx];
                }

                // CASE 2 : odd -> odd
                // Sum remains unchanged

                ans[i++] = sum;

            } else {

                // Store old even value
                int evenVal = nums[idx];

                // Update the number
                nums[idx] = nums[idx] + value;

                // CASE 3 : even -> even
                // Remove old even value and add new even value
                if (nums[idx] % 2 == 0) {

                    sum += nums[idx] - evenVal;

                } else {

                    // CASE 4 : even -> odd
                    // Remove old even value from sum
                    sum -= evenVal;

                }

                ans[i++] = sum;
            }
        }

        return ans;
    }
}