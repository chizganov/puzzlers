package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem">Fibonacci Numbers challenge</a>
 *
 * @author Ev Chizganov
 */
class FibonacciNumbers {

    int fibonacci(int n) {
        int[] fib = new int[2];
        fib[1] = 1;

        for (int i = 2; i <= n; i++)
            fib[i % 2] = fib[0] + fib[1];

        return fib[n % 2];
    }

}
