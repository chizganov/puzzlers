package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem>Jumping on the Clouds challenge</a>
 *
 * @author Ev Chizganov
 * */
class JumpingOnTheClouds {

    int jumpingOnClouds(int[] c) {
        int jumps = 1;
        for(int i = 0; i < c.length-3;) {
            i += c[i+2] == 0 ? 2 : 1;
            jumps++;
        }

        return jumps;
    }

}