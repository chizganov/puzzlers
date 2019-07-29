package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Arrays;

/**
 * <a href="https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem">Organizing Containers of Balls challenge</a>
 *
 * @author Ev Chizganov
 * */
class BallContainer {

    /**
     * Perform some number of swap operations such that:
     *  -Each container contains only balls of the same type.
     *  -No two balls of the same type are located in different containers.
     * Example:
     *  input:
     *      1 1
     *      1 1
     *  output:
     *      2 0
     *      0 2
     *
     * @param container matrix that represents container in rows and balls types in columns
     * @return "Possible" if satisfy the conditions above, "Impossible" otherwise
     * */
    String organizingContainers(int[][] container) {
        /*
        * 1) Calculate tne capacity and ball of appropriate type
        * 2) Sort capacity and balls
        * 3) Possible if equals, Impossible otherwise
        * */
        int length = container.length;
        int[] capacity = new int[length];
        int[] ballCount = new int[length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                capacity[i] += container[i][j];
                ballCount[j] += container[i][j];
            }
        }

        Arrays.sort(capacity);
        Arrays.sort(ballCount);

        if(Arrays.equals(capacity, ballCount)) return "Possible";

        return "Impossible";
    }

}
