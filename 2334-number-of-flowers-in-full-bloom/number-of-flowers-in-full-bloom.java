class Solution {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // difference array events
        for (int[] f : flowers) {

            map.put(f[0],
                    map.getOrDefault(f[0], 0) + 1);

            map.put(f[1] + 1,
                    map.getOrDefault(f[1] + 1, 0) - 1);
        }

        // convert difference array into prefix sums
        int current = 0;

        for (int key : map.keySet()) {

            current += map.get(key);

            map.put(key, current);
        }

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {

            Integer key = map.floorKey(people[i]);

            if (key == null) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(key);
            }
        }

        return ans;
    }
}