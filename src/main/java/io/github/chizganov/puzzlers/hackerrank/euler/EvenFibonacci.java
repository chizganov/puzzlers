package io.github.chizganov.puzzlers.hackerrank.euler;

/**
 * <a href="hackerrank.com/contests/projecteuler/challenges/euler002/problem">Project Euler #2: Even Fibonacci numbers</a>
 *
 * @author Ev Chizganov
 */
class EvenFibonacci {

    long evenFibSum(long n) {
        long curEvenFib = 2;
        long prevEvenFib = 0;

        long sum = prevEvenFib;

        while (curEvenFib <= n) {
            sum += curEvenFib;

            long t = curEvenFib;
            curEvenFib = curEvenFib * 4 + prevEvenFib;
            prevEvenFib = t;
        }

        return sum;
    }

}
