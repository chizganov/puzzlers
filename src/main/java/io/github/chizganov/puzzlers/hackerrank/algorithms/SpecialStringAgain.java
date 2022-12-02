package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/special-palindrome-again/problem">Special String Again challenge</a>
 *
 * @author Ev Chizganov
 */
class SpecialStringAgain {

    long substrCount(int n, String s) {
        long count = n;
        int mid = -1;
        int eqSeq = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count += eqSeq;
                eqSeq++;
                if ((mid - eqSeq >= 0) && s.charAt(mid - eqSeq) == s.charAt(i)) count++;
                else mid = -1;
            } else {
                eqSeq = 1;
                if ((i - 2 >= 0) && s.charAt(i - 2) == s.charAt(i)) {
                    count++;
                    mid = i - 1;
                } else mid = -1;
            }
        }

        return count;
    }

}
