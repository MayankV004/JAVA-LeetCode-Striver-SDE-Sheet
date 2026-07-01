class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer , Integer> map = new TreeMap<>();

        for(int []match : matches){
            int winner = match[0];
            int loser = match[1];

            if(!map.containsKey(winner)){
                map.put(winner , 0);
            }

            map.put(loser , map.getOrDefault(loser , 0) + 1);

        } 

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for(int it : map.keySet()){
            int val = map.get(it);
            if(val == 0) noLoss.add(it);
            if(val == 1) oneLoss.add(it);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(noLoss);
        ans.add(oneLoss);

        return ans;
    }
}