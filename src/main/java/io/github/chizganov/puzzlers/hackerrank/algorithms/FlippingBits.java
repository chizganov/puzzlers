package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/flipping-bits/problem">Flipping bits challenge</a>
 *
 * @author Ev Chizganov
 */
class FlippingBits {

    long flippingBits(long n) {
        return n ^ 0xFFFFFFFFL;
    }

}
