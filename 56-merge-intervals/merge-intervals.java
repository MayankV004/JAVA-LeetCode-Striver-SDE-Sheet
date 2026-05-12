class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= end) { // merging the intervals

                end = Math.max(end, currEnd);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                ans.add(temp);
                start = currStart;
                end = currEnd;
            }

        }
        List<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        ans.add(temp);

        int [][]result = new int[ans.size()][2];

        for(int i = 0 ; i < ans.size() ; i++){
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;

    }
}