class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a,b)->Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1 ; i < n ; i++)
        {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart >= start && currStart <= end)
            {
                if(currEnd > end)
                {
                    end = currEnd;
                }
            }else if(currStart > end)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end);
                ans.add(temp);
                start = currStart ;
                end = currEnd;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(start);
        temp.add(end);
        ans.add(temp);
        // Now converting ArrayList to Normal Array[][]
        int [][]arr = new int[ans.size()][2];

        for(int i = 0 ; i < ans.size() ; i++)
        {
            arr[i][0] = ans.get(i).get(0);
            arr[i][1] = ans.get(i).get(1);
        } 
        return arr;
    }
}