package io.github.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/">First Unique Character in a String challenge</a>
 *
 * @author Ev Chizganov
 */
class FirstUniqueChar {

    int firstUniqChar(String s) {
        Map<Character, Integer> charToOccurrences = new HashMap<>();

        for (char c : s.toCharArray())
            charToOccurrences.merge(c, 1, Integer::sum);

        for (int i = 0; i < s.length(); i++)
            if (charToOccurrences.get(s.charAt(i)) == 1) return i;

        return -1;
    }

}
