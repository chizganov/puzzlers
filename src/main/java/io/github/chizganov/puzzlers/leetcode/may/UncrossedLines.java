package io.github.chizganov.puzzlers.leetcode.may;

import static java.lang.Integer.max;

class UncrossedLines {

    int maxUncrossedLines(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) return 0;

        // Uncrossed lines number in A[i:]B[j:]
        int[][] uncrossedLines = new int[a.length + 1][b.length + 1];

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                uncrossedLines[i][j] = max(max(uncrossedLines[i + 1][j], uncrossedLines[i][j + 1]),
                        uncrossedLines[i + 1][j + 1] + (a[i] == b[j] ? 1 : 0));
            }
        }

        return uncrossedLines[0][0];
    }

}
