package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-bubble-sort/problem">Sherlock and Anagrams challenge</a>
 *
 * @author Ev Chizganov
 */
class BubbleSort {

    private int numSwaps;

    void countSwaps(int[] a) {
        numSwaps = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    numSwaps++;
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    int getNumSwaps() {
        return numSwaps;
    }

}
