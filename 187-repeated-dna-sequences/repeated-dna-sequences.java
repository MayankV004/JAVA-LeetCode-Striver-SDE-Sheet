class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
        // Set<String> set = new HashSet<>();
        // Set<String> repeated = new HashSet<>();
        // List<String> res = new ArrayList<>();
        // int n = s.length();
        // if(n < 10 ) return res;
        // String str = s.substring(0 , 10);
        // StringBuilder sb = new StringBuilder(str);
        // set.add(str);

        // for(int i = 10 ; i < n; i++){
        //     sb.append(s.charAt(i));
        //     sb.deleteCharAt(0);
        //     String curr = sb.toString();
        //     if(set.contains(curr)){
        //         if(repeated.add(curr)){ // preventing adding duplicate answer in res
        //             res.add(curr);
        //         }
        //     }else{
        //         set.add(curr); // update set
        //     }
        // }

        // return res;

        Set<String> seen = new HashSet<>();
        Set<String> added = new HashSet<>();

        for(int i = 0; i <= str.length() - 10; i++) {
            String current = str.substring(i, i + 10);
            if(!seen.add(current)) {
                added.add(current);
            }
        }

        return new ArrayList<>(added);
    }
}