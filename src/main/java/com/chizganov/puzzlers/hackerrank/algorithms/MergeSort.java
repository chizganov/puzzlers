package com.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Math.min;
import static java.lang.System.arraycopy;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-merge-sort/problem">Merge Sort: Counting Inversions challenge</a>
 *
 * @author Ev Chizganov
 */
class MergeSort {

    long countInversions(int[] arr) {
        long swaps = 0;
        int n = arr.length;
        int[] copy = new int[n];

        for (int k = 2; k < n * 2; k *= 2) {
            for (int left = 0; left < n; left += k) {
                int middle = min(left + k / 2, n);
                int right = min(left + k, n);

                arraycopy(arr, left, copy, left, right - left);

                int lIter = left;
                int rIter = middle;
                int i = left;

                while (lIter < middle && rIter < right) {
                    if (copy[lIter] <= copy[rIter]) {
                        swaps += lIter - i > 0 ? lIter - i : 0;
                        arr[i] = copy[lIter++];
                    } else {
                        swaps += rIter - i > 0 ? rIter - i : 0;
                        arr[i] = copy[rIter++];
                    }
                    i++;
                }
                while (lIter < middle) arr[i++] = copy[lIter++];
                while (rIter < right) arr[i++] = copy[rIter++];
            }
        }

        return swaps;
    }

}
