package com.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/">Permutation in String problem</a>
 *
 * @author Ev Chizganov
 */
class PermutationInString {

    boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charToCount = new HashMap<>();
        int commonLeft = s1.length();

        for (char c : s1.toCharArray()) charToCount.merge(c, 1, Integer::sum);
        for (int i = 0, firstIndex = 0; i < s2.length(); i++) {
            if (i - firstIndex == s1.length()) {
                Integer left = charToCount.computeIfPresent(s2.charAt(firstIndex), (k, v) -> v + 1);
                if (left != null && left > 0) commonLeft++;
                firstIndex++;
            }

            char c = s2.charAt(i);
            Integer left = charToCount.computeIfPresent(c, (k, v) -> v - 1);
            if (left != null && left >= 0) commonLeft--;

            if (commonLeft == 0) return true;
        }

        return false;
    }

}
