package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.stream.IntStream;

/**
 * <a href="https://www.hackerrank.com/challenges/absolute-permutation/problem">Absolute Permutation challenge</a>
 *
 * @author Ev Chizganov
 * */
class AbsolutePermutation {

    /**
     * P is an absolute permutation of the first n natural numbers in the rang [1,n].
     * Let pos[i] denote the value at position i in permutation P using 1-based indexing.
     * P is considered to be an absolute permutation if |pos[i]-i|=k holds true for every i in [1,n].
     *
     * @param n the upper bound of natural numbers to consider
     * @param k the integer difference between each element and its index
     * @return smallest absolute permutation, -1 if there is none
     * */
    int[] absolutePermutation(int n, int k) {
        /*
        * If k = 0: 1..n
        * If n % (k*2) != 0: -1
        * example:
        *   1 2 3 4 5 6 7 8 9
        *   4 5 6 1 2 3 ? ? ?
        *
        * otherwise permutation alternate every k elements: a[i] = i +(-) k.
        * */
        if(k == 0) {
            return IntStream.range(1, n+1).toArray();
        }

        if(n % (k*2) != 0) {
            return new int[] { -1 };
        }

        int[] a = new int[n];
        int sign = 1;
        for(int i = 0; i < n; i++) {
            a[i] = i + sign * k + 1;
            if((i+1) % k == 0) {
                sign = sign == 1 ? -1 : 1;
            }
        }

        return a;
    }

}
