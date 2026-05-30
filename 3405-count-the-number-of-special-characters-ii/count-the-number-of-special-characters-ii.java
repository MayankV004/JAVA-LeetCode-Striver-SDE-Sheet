class Solution {
    public int numberOfSpecialChars(String word) {

        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];
        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            // lowercase
            if (Character.isLowerCase(ch)) {

                lastLower[ch - 'a'] = i;
            }
            // uppercase
            else {
                int idx = ch - 'A';
                // store only first occurrence
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 &&
                    firstUpper[i] != -1 &&
                    firstUpper[i] > lastLower[i]) {

                ans++;
            }
        }

        return ans;
    }
}
// Using HashMap
// class Solution {
//     public int numberOfSpecialChars(String word) {
//         Map<Character, Integer> map = new HashMap<>();
//         char arr[] = word.toCharArray();
//         int n = word.length();
//         for (int i = 0; i < n; i++) {
//             char ch = arr[i];
//             if ('a' <= ch && ch <= 'z') {
//                 map.put(ch, i);
//             } else if ('A' <= ch && ch <= 'Z' && !map.containsKey(ch)) {
//                 map.put(ch, i);
//             }
//         }
//         int ans = 0;
//         for (Character ch : map.keySet()) {
//             // since a-97 and A - 65 , therefore difference is of 32  
//             if ('a' <= ch && ch <= 'z') {
//                 char upperChar = Character.toUpperCase(ch); // another way-> (char)(ch - 32);
//                 if (map.containsKey(upperChar)) {
//                     int lastIdxOfLower = map.get(ch);
//                     int firstIdxOfUpper = map.get(upperChar);

//                     if (firstIdxOfUpper > lastIdxOfLower) {
//                         ans++;
//                     }
//                 }

//             }
//         }
//         return ans;
//     }
// }