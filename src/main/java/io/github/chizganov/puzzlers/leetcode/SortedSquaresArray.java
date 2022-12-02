package io.github.chizganov.puzzlers.leetcode;

import java.util.Arrays;

class SortedSquaresArray {

    public int[] sortedSquares(int[] a) {
        int firstNonNegativeIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) firstNonNegativeIndex++;
            a[i] = a[i] * a[i];
        }

        int[] negativeArr = Arrays.copyOf(a, firstNonNegativeIndex);

        int positiveIter = firstNonNegativeIndex;
        int negativeIter = negativeArr.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (negativeIter >= 0 && (positiveIter >= a.length || negativeArr[negativeIter] < a[positiveIter])) {
                a[i] = negativeArr[negativeIter];
                negativeIter--;
            } else {
                a[i] = a[positiveIter];
                positiveIter++;
            }
        }

        return a;
    }

}
