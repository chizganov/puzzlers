package io.github.chizganov.puzzlers.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.sort;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem">Sherlock and Anagrams challenge</a>
 *
 * @author Ev Chizganov
 */
class SherlockAndAnagrams {

    private static final int[] combinations = new int[100];

    static {
        combinations[0] = 0;
        for (int i = 1; i < 100; i++) {
            combinations[i] = i + combinations[i - 1];
        }
    }

    int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j <= s.length(); j++)
                map.merge(alphabetize(s.substring(i, j)), 1, Integer::sum);

        int result = 0;
        for (int i : map.values()) result += combinations[i - 1];

        return result;
    }

    private String alphabetize(String s) {
        char[] c = s.toCharArray();
        sort(c);

        return new String(c);
    }

}
