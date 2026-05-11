class Solution {

    // Function to calculate:
    // sum of squares of digits of a number
    //
    // Example:
    // n = 19
    //
    // 1² + 9² = 1 + 81 = 82

    public int getNext(int n) {

        int sum = 0;

        while (n > 0) {

            // Extract last digit
            int digit = n % 10;

            // Add square of digit
            sum += digit * digit;

            // Remove last digit
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {

        // Floyd's Cycle Detection Algorithm

        // slow moves 1 step
        // fast moves 2 steps

        int slow = n;
        int fast = getNext(n);

        // Continue until:
        // 1. fast becomes 1  -> happy number
        // OR
        // 2. slow meets fast -> cycle detected

        while (fast != 1 && slow != fast) {

            // Move slow by one transformation
            slow = getNext(slow);

            // Move fast by two transformations
            fast = getNext(getNext(fast));
        }

        // If fast reaches 1,
        // number is happy

        return fast == 1;
    }
}