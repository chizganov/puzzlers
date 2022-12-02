package io.github.chizganov.puzzlers.hackerrank.euler;

import static java.lang.Math.sqrt;

/**
 * <a href="https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem">Project Euler #3: Largest prime factor</a>
 *
 * @author Ev Chizganov
 */
class LargestPrimeFactor {

    long largestPrimeFactor(long n) {
        long largestPrimeFactor = n % 2 == 0 ? 2 : 1;

        while (n % 2 == 0) n /= 2;
        for (int i = 3; i <= sqrt(n); i += 2) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }

        return n > 2 ? n : largestPrimeFactor;
    }

}
