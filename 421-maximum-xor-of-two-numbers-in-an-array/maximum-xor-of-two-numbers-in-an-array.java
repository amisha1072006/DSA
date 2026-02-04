class Solution {
    public int findMaximumXOR(int[] nums) {
                TrieNode root = new TrieNode();

        for(final int num : nums) {
            TrieNode curr = root;
            for(int i = 30; i >= 0; i--) {
                final int bit = (num >> i) & 1;

                if(curr.children[bit] == null)
                    curr.children[bit] = new TrieNode();

                curr = curr.children[bit];
            }
        }

        int max = 0;

        for(final int num : nums) {
            TrieNode curr = root;
            int currSum = 0;

            for(int i = 30; i >= 0; --i) {
                int bit = 1 - ((num >> i) & 1);

                if(curr.children[bit] == null) {
                    curr = curr.children[1 - bit];
                } else {
                    currSum |= 1 << i;
                    curr = curr.children[bit];
                }
            }

            max = Math.max(max, currSum);
        }

        return max;
    }

    private class TrieNode {
        public final TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[2];
        }
    
    }
}