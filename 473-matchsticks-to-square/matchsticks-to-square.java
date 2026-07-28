class Solution {

    boolean dfs(int[] sticks, int idx, int[] sides, int target) {

        if (idx == sticks.length)
            return true;

        int stick = sticks[idx];

        for (int i = 0; i < 4; i++) {

            if (sides[i] + stick > target)
                continue;

            // Choose
            sides[i] += stick;

            // Explore
            if (dfs(sticks, idx + 1, sides, target))
                return true;

            // Undo
            sides[i] -= stick;

            // Pruning:
            // If this side was empty and didn't work,
            // no need to try other empty sides.
            if (sides[i] == 0)
                break;
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        for (int x : matchsticks)
            sum += x;

        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        Arrays.sort(matchsticks);

        // Reverse to descending order
        for (int l = 0, r = matchsticks.length - 1; l < r; l++, r--) {
            int temp = matchsticks[l];
            matchsticks[l] = matchsticks[r];
            matchsticks[r] = temp;
        }

        if (matchsticks[0] > target)
            return false;

        return dfs(matchsticks, 0, new int[4], target);
    }
}