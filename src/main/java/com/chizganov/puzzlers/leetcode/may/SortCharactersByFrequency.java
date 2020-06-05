package com.chizganov.puzzlers.leetcode.may;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3337/">Sort Characters By Frequency problem</a>
 *
 * @author Ev Chizganov
 */
class SortCharactersByFrequency {

    String frequencySort(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();

        for (char c : s.toCharArray()) charToCount.merge(c, 1, Integer::sum);

        StringBuilder sb = new StringBuilder(s.length());
        charToCount.entrySet().stream().sorted(comparingByValue(reverseOrder())).forEachOrdered(e -> {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        });

        return sb.toString();
    }

}
