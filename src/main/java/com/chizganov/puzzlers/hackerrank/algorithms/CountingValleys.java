package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/counting-valleys/problem>Counting Valleys challenge</a>
 *
 * @author Ev Chizganov
 * */
class CountingValleys {

    int countingValleys(String s) {
        int level = 0;
        int valleys = 0;
        for(char c : s.toCharArray()) {
            if(c == 'U') {
                if(level == -1) valleys++;
                level++;
            }
            else if(c == 'D') level--;
        }

        return valleys;
    }

}
