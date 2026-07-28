class Solution {

    List<Integer> ans = new ArrayList<>();

    public boolean dfs(String s, int idx) {

        if (idx == s.length()) {
            return ans.size() >= 3;
        }

        long num = 0;

        for (int i = idx; i < s.length(); i++) {

            // Leading zero
            if (i > idx && s.charAt(idx) == '0')
                break;

            num = num * 10 + (s.charAt(i) - '0');

            if (num > Integer.MAX_VALUE)
                break;

            int size = ans.size();

            if (size >= 2) {

                long expected = (long) ans.get(size - 1) + ans.get(size - 2);

                if (num < expected)
                    continue;

                if (num > expected)
                    break;
            }

            ans.add((int) num);

            if (dfs(s, i + 1))
                return true;

            ans.remove(ans.size() - 1);
        }

        return false;
    }

    public List<Integer> splitIntoFibonacci(String num) {

        dfs(num, 0);

        return ans;
    }
}