class Solution {
    static class TrieNode {
        TrieNode left;
        TrieNode right;
    }

    public void insertInBinaryTrie(TrieNode root, int num) {
        TrieNode pCrawl = root;

        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;

            if (ithBit == 0) {
                if (pCrawl.left == null) {
                    pCrawl.left = new TrieNode();
                }
                pCrawl = pCrawl.left;
            } else {
                if (pCrawl.right == null) {
                    pCrawl.right = new TrieNode();
                }
                pCrawl = pCrawl.right;
            }
        }
    }

    public int maxXor(TrieNode root, int num) {
        int maxi = 0;
        TrieNode pCrawl = root;
        for (int i = 31; i >= 0; i--) {
            int ithBit = (num >> i) & 1;

            if (ithBit == 0) {
                if (pCrawl.right != null) {
                    maxi += Math.pow(2, i);
                    pCrawl = pCrawl.right;
                } else {
                    pCrawl = pCrawl.left;
                }
            } else {
                if (pCrawl.left != null) {
                    maxi += Math.pow(2, i);
                    pCrawl = pCrawl.left;
                } else {
                    pCrawl = pCrawl.right;
                }
            }
        }
        return maxi;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();

        for (int it : nums) {
            insertInBinaryTrie(root, it);
        }

        int result = 0;

        for (int it : nums) {
            result = Math.max(result, maxXor(root, it));
        }

        return result;
    }

}