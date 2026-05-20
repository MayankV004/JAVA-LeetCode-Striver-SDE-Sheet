class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer , Long> events = new TreeMap<>();

        for(int[] segment : segments){
            int start = segment[0];
            int end   = segment[1];
            long color = segment[2];

            events.merge(start , color , Long::sum);
            events.merge(end , -1 * color , Long::sum);

        }

        List<List<Long>> result = new ArrayList<>();

        long sum = 0;

        Integer prev = null;

        for(Map.Entry<Integer , Long> e : events.entrySet()){
            int point = e.getKey();

            if( prev != null && sum > 0){
                result.add(Arrays.asList((long)prev , (long)point , (long)sum));
            }

            sum += e.getValue();
            prev = point;
        }

        return result;


    }
}