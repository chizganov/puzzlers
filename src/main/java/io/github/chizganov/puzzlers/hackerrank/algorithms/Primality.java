package io.github.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Math.sqrt;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-big-o/problem">Time Complexity: Primality challenge</a>
 *
 * @author Ev Chizganov
 */
class Primality {

    private static final String PRIME = "Prime";
    private static final String NOT_PRIME = "Not prime";

    String primality(int n) {
        if (n == 2) return PRIME;
        if (n == 1 || n % 2 == 0) return NOT_PRIME;

        for (int i = 3; i <= sqrt(n); i += 2) {
            if (n % i == 0) return NOT_PRIME;
        }

        return PRIME;
    }

}
