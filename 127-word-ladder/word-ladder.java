class Pair{
    String word ; int level;
    Pair(String word , int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public boolean isDifferenceOne(String s1 , String s2){
        int count = 0 ;
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
            }
        }
        return count > 1 ? false : true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord.length() != endWord.length() || beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }
        int visited[] = new int[wordList.size()];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        while(!q.isEmpty()){
            String s = q.peek().word;
            int level= q.peek().level;
            q.poll();

            if(s.equals(endWord)){
                return level;
            }
            
            for(int i = 0 ; i < wordList.size() ; i++){
                if( visited[i] == 0 && isDifferenceOne(s, wordList.get(i))){
                   q.add(new Pair(wordList.get(i) , level + 1));
                   visited[i] = 1;
                    
                }
            }
            
        }
        return 0;

    }
}

// class Pair{
//     String word ; int level;
//     Pair(String word , int level){
//         this.word = word;
//         this.level = level;
//     }
// }
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> set = new HashSet<>();
//         for(String str : wordList){
//             set.add(str);
//         }
//         if(beginWord.length() != endWord.length() || beginWord.equals(endWord) || !set.contains(endWord)){
//             return 0;
//         }

//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(beginWord , 1));
//         while(!q.isEmpty()){
//             String s = q.peek().word;
//             int level= q.peek().level;
//             q.poll();
//             if(s.equals(endWord)){
//                 return level;
//             }
            
//             for(int i = 0 ; i < s.length() ; i++){
//                 for(char j = 'a' ; j <= 'z' ; j++){
//                     StringBuilder sb = new StringBuilder(s);
//                     sb.setCharAt(i , j);
//                     String newWord = sb.toString();
//                     if(set.contains(newWord)){
//                         set.remove(newWord);
//                         q.add(new Pair(newWord, level+1));
//                     }
                    
//                 }
//             }

//         }
//         return 0;

//     }
// }


