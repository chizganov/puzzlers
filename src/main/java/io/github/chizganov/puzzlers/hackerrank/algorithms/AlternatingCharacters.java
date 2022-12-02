package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/alternating-characters/problem">Alternating Characters challenge</a>
 *
 * @author Ev Chizganov
 * */
class AlternatingCharacters {

    int alternatingCharacters(String s) {
        int delCount = 0;
        char[] c = s.toCharArray();

        for(int i = 1; i < c.length; i++) {
            delCount += c[i] == c[i-1] ? 1 : 0;
        }

        return delCount;
    }

}
