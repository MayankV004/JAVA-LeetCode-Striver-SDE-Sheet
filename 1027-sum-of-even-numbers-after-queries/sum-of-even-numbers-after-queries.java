class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;

        for (int num : nums) {
            if (num % 2 == 0)
                sum += num;
        }

        // now we will have the sum of all even numbers of the array;
        int ans[] = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int value = query[0];
            int idx = query[1];

            boolean oldNumValue = nums[idx] % 2 == 0;
            // System.out.println("Query - "+ i + " - "  + nums[idx]);

            if (!oldNumValue) { // odd
                nums[idx] = nums[idx] + value;

                if (nums[idx] % 2 == 0) {
                    sum += nums[idx];
                }

                ans[i++] = sum;
            } else {
                int evenVal = nums[idx];
                nums[idx] = nums[idx] + value;

                if (nums[idx] % 2 == 0) {
                    sum += nums[idx] - evenVal;

                } else {
                    sum -= evenVal;

                }
                ans[i] = sum;
                i++;

            }

        }
        // for(int j = 0 ; j < queries.length ; j++){
        //     System.out.println(ans[j]);
        // }
        return ans;
    }
}