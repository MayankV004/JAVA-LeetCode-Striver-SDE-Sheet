class Solution {
    public int findDuplicate(int[] nums) {

        // Floyd's Cycle Detection Algorithm

        // We treat:
        // index = node
        // nums[index] = next pointer

        // Example:
        // nums = [1,3,4,2,2]
        //
        // 0 -> 1
        // 1 -> 3
        // 3 -> 2
        // 2 -> 4
        // 4 -> 2
        //
        // Cycle: 2 -> 4 -> 2

        int slow = 0;
        int fast = 0;

        // -------------------------------
        // PHASE 1 : Detect cycle
        // -------------------------------
        //
        // slow moves 1 step
        // fast moves 2 steps
        //
        // If a cycle exists, they must meet
        // somewhere inside the cycle.

        while (true) {

            // Move one step
            slow = nums[slow];

            // Move two steps
            fast = nums[nums[fast]];

            // Collision point inside cycle
            if (slow == fast) {

                // -----------------------------------
                // PHASE 2 : Find cycle entrance
                // -----------------------------------
                //
                // Put one pointer at start (0)
                // Keep another at meeting point
                //
                // Move both one step at a time.
                //
                // Where they meet again
                // is the duplicate number.

                int start = 0;

                while (true) {

                    // Move both one step
                    start = nums[start];
                    slow = nums[slow];

                    // Cycle entrance found
                    if (start == slow) {

                        // This node itself is duplicate
                        return start;
                    }
                }
            }
        }
    }
}