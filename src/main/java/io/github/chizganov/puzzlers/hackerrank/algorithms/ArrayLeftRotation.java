package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem">Arrays: Left Rotation challenge</a>
 *
 * @author Ev Chizganov
 * */
class ArrayLeftRotation {

    int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            result[i] = a[(i+d)%a.length];
        }

        return result;
    }

}
