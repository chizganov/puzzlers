package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/two-strings/problem">Two Strings challenge</a>
 *
 * @author Ev Chizganov
 */
class TwoStrings {

    String twoStrings(String s1, String s2) {
        boolean[] alphabet = new boolean[28];

        String s = s1.length() < s2.length() ? s1 : s2; // get smallest string
        for(char c : s.toCharArray()) alphabet[c - 'a'] = true;

        s = s1.length() >= s2.length() ? s1 : s2; // get second string
        for(char c : s.toCharArray()) if (alphabet[c - 'a']) return "YES";

        return "NO";
    }

}
