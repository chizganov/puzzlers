package com.chizganov.puzzlers.hackerrank.euler;

/**
 * <a href="https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem">Project Euler #1: Multiples of 3 and 5 challenge</a>
 *
 * @author Ev Chizganov
 */
class MultiplesOfThreeAndFive {

    long multiples(int n) {
        return arithmeticProgressionSum(3, (n - 1) / 3, 3) +
                arithmeticProgressionSum(5, (n - 1) / 5, 5) -
                arithmeticProgressionSum(15, (n - 1) / 15, 15);
    }

    private long arithmeticProgressionSum(int a1, long n, int d) {
        return (2L * a1 + (n - 1) * d) * n / 2;
    }

}
