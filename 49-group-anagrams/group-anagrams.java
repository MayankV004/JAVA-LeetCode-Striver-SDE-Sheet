class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i = 0 ; i < n ; i++){
            char ch[] = strs[i].toCharArray();
            Arrays.sort(ch);

            String str = new String(ch);

            map.putIfAbsent(str , new ArrayList<>());
            map.get(str).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}