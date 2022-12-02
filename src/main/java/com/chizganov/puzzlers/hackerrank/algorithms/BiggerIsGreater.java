package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/bigger-is-greater/problem">Bigger Is Greater challenge</a>
 *
 * @author Ev Chizganov
 * */
class BiggerIsGreater {

    String biggerIsGreater(String w) {
        /*
         * Use next lexicographical algorithm:
         * 1) Find the largest index i such that array[i − 1] < array[i].
         *   (If no such `i` exists, then this is already the last permutation.)
         * 2) Find the largest index j such that j ≥ i and array[j] > array[i − 1].
         * 3) Swap array[j] and array[i − 1].
         * 4) Reverse the suffix starting at array[i].
         * */
        final int l = w.length();
        final String na = "no answer";

        if(l <= 1) return na;

        // Find pivot index
        int i = l - 2;
        while(i >= 0 && w.charAt(i) >= w.charAt(i+1)) i--;
        if(i < 0) return na;

        final int pivot = i;
        final char[] prefix = w.substring(0, pivot + 1).toCharArray();
        final char[] suffix = w.substring(pivot + 1, l).toCharArray();
        // Find pivot position (i-1)
        i = 0;
        while(i < suffix.length && prefix[pivot] < suffix[i]) i++;
        // Swap
        final char c = prefix[pivot];
        prefix[pivot] = suffix[i-1];
        suffix[i-1] = c;

        return String.valueOf(prefix) + new StringBuilder().append(suffix).reverse();
    }

}
