package com.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

/**
 * <a href="https://www.hackerrank.com/challenges/abbr/problem">Abbreviation challenge</a>
 *
 * @author Ev Chizganov
 */
class Abbreviation {

    private static final String YES = "YES";
    private static final String NO = "NO";

    String abbreviation(String a, String b) {
        boolean[][] subproblems = new boolean[b.length()][a.length()];
        boolean solved = false;
        for (int j = 0; j < a.length(); j++) {
            if (equalsIgnoreCase(a.charAt(j), b.charAt(0))) solved = true;
            else if (isUpperCase(a.charAt(j))) solved = false;
            subproblems[0][j] = solved;
        }

        for (int i = 1; i < b.length(); i++) {
            solved = false;
            for (int j = i; j < a.length(); j++) {
                if (subproblems[i - 1][j - 1] && equalsIgnoreCase(a.charAt(j), b.charAt(i)))
                    solved = true;
                else if (isUpperCase(a.charAt(j))) solved = false;
                subproblems[i][j] = solved;
            }
        }

        return solved ? YES : NO;
    }

    private static boolean equalsIgnoreCase(char a, char b) {
        return toLowerCase(a) == toLowerCase(b);
    }

}
