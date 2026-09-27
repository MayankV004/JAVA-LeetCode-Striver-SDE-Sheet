class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer , Integer> map = new TreeMap<>();

        for(int []trip : trips){
            int start = trip[1];
            int end = trip[2];
            int passenger = trip[0];

            map.put(start , map.getOrDefault(start , 0) + passenger);
            map.put(end , map.getOrDefault(end , 0) - passenger);

        }

        int currentCapacity = 0;
        for(int delta : map.values()){
            currentCapacity += delta;
            if(currentCapacity > capacity){
                return false;
            }
        }

        return true;
    }
}