class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer , List<Integer>> map = new TreeMap<>();

        for(int []trip : trips){
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];
            // for from 
            if(!map.containsKey(start)){
                map.put(start , new ArrayList<>());
            }
            map.get(start).add(passengers);

            // for (to)

            if(!map.containsKey(end)){
                map.put(end, new ArrayList<>());
            }
            map.get(end).add(-1*passengers);

        }

        int currentPassengers = 0;

        for(List<Integer> list : map.values()){
            for(int it : list){
                currentPassengers += it;
            }
            if(currentPassengers > capacity) return false;
        }

        return true;
    }
}