class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String , List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            char []temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            if(!map.containsKey(sortedStr) ){
                map.put(sortedStr , new ArrayList<>());
            }

            map.get(sortedStr).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}