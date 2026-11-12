class Solution {
    public int maxVowels(String s, int k) {

        int maxVowel = 0;
        int count = 0;
        String vowels = "aeiou";
        int n = s.length();

        // Count vowels in the first window
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }

        maxVowel = count;

        // Slide the window
        for (int i = k; i < n; i++) {

            // Remove outgoing character
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                count--;
            }

            // Add incoming character
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }

            maxVowel = Math.max(maxVowel, count);

            // Optimization: maximum possible answer reached
            if (maxVowel == k) {
                return k;
            }
        }

        return maxVowel;
    }
}