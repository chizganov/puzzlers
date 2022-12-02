package io.github.chizganov.puzzlers.leetcode.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/">Find All Anagrams in a String problem</a>
 *
 * @author Ev Chizganov
 */
@SuppressWarnings("DuplicatedCode")
class FindAllAnagrams {

    List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramFirstOccurrences = new ArrayList<>(s.length());
        Map<Character, Integer> charToCount = new HashMap<>();
        int commonLeft = p.length();

        for (char c : p.toCharArray()) charToCount.merge(c, 1, Integer::sum);
        for (int i = 0, firstIndex = 0; i < s.length(); i++) {
            if (i - firstIndex == p.length()) {
                Integer left = charToCount.computeIfPresent(s.charAt(firstIndex), (k, v) -> v + 1);
                if (left != null && left > 0) commonLeft++;
                firstIndex++;
            }

            char c = s.charAt(i);
            Integer left = charToCount.computeIfPresent(c, (k, v) -> v - 1);
            if (left != null && left >= 0) commonLeft--;

            if (commonLeft == 0) anagramFirstOccurrences.add(firstIndex);
        }

        return anagramFirstOccurrences;
    }

}
