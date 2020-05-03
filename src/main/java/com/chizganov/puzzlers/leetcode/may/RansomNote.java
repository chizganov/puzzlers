package com.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/">Ransome Note challenge</a>
 *
 * @author Ev Chizganov
 */
class RansomNote {

    boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char letter : magazine.toCharArray()) charToCount.merge(letter, 1, Integer::sum);
        for (char letter : ransomNote.toCharArray()) {
            Integer count = charToCount.computeIfPresent(letter, (key, value) -> value - 1);
            if (count == null || count < 0) return false;
        }

        return true;
    }

}
