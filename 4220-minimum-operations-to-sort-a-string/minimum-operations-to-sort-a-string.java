class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean isSorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char smallestChar = s.charAt(0);
        char largestChar = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);

            if (current < smallestChar) {
                smallestChar = current;
            }

            if (current > largestChar) {
                largestChar = current;
            }
        }

        if (s.charAt(0) == smallestChar ||
            s.charAt(n - 1) == largestChar) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            char current = s.charAt(i);

            if (current == smallestChar ||
                current == largestChar) {
                return 2;
            }
        }

        return 3;
    }
}