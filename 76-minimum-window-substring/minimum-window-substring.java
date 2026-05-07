class Solution {
    public String minWindow(String s, String t) {
        if(t.equals(s)){
            return s;
        }
        if(t.length() > s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+ 1);
        }

        int i = 0 ; int j = 0;
        int start_i = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int requiredCount = t.length();

        while(j < s.length()){
           
            char jthChar = s.charAt(j);

            if(map.containsKey(jthChar) && map.get(jthChar) > 0){
                requiredCount --; // got one character of t
            }
            // if character not in the map then add it with -ve count
            map.put(jthChar , map.getOrDefault(jthChar , 0) - 1); 

            while(requiredCount == 0){ // if we got out window then we try to shrink it to get min window
                int currWindowSize = j - i + 1;

                if(minWindowSize > currWindowSize){
                    minWindowSize = currWindowSize;
                    start_i = i;
                }

                char ithChar = s.charAt(i);
                // as we are shrinking so we have to increase the freq count of the character in map
                map.put(ithChar , map.getOrDefault(ithChar , 0 )+1);

                if(map.containsKey(ithChar) && map.get(ithChar) > 0){  
                    // updating the requiredCount if the character was of string T
                    requiredCount ++ ;
                }
                i++;
            }
            j++;
            
       
        }
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i+ minWindowSize);
    }



}