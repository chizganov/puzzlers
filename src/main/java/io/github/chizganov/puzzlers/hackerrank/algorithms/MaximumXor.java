package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/maximum-xor/problem">Maximum Xor challenge</a>
 *
 * @author Ev Chizganov
 */
class MaximumXor {

    private static final int LEFT_BIT_MASK = 0b10000000_00000000_00000000_00000000;

    int[] maxXor(int[] arr, int[] queries) {
        int[] maxXors = new int[queries.length];

        // Construct BitTrie - tree that represents bit sequences (of arr elements in that case)
        BitTrie trie = new BitTrie();
        for (int element : arr) {
            BitTrie parent = trie;
            for (int i = 0; i < Integer.SIZE; i++) {
                if ((element & LEFT_BIT_MASK) == LEFT_BIT_MASK) parent = parent.setOne();
                else parent = parent.setZero();
                element <<= 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            // Ideal case for max xor is reversed number
            int reversed = ~queries[i];
            BitTrie parent = trie;
            int max = 0;
            for (int j = 0; j < Integer.SIZE; j++) {
                max <<= 1;
                boolean isOne = (reversed & LEFT_BIT_MASK) == LEFT_BIT_MASK;
                if (isOne && parent.hasOne() || !isOne && !parent.hasZero() && parent.hasOne()) {
                    max |= 1;
                    parent = parent.one;
                } else {
                    parent = parent.zero;
                }

                reversed <<= 1;
            }

            maxXors[i] = max ^ queries[i];
        }

        return maxXors;
    }

    private static final class BitTrie {

        private BitTrie zero;
        private BitTrie one;

        BitTrie setZero() {
            if (zero == null) {
                zero = new BitTrie();
            }

            return zero;
        }

        BitTrie setOne() {
            if (one == null) {
                one = new BitTrie();
            }

            return one;
        }

        boolean hasZero() {
            return zero != null;
        }

        boolean hasOne() {
            return one != null;
        }

    }

}
