package io.github.chizganov.puzzlers.leetcode.may;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3317/">JewelsAndStones challenge</a>
 *
 * @author Ev Chizganov
 */
class JewelsAndStones {

    int numJewelsInStones(String J, String S) {
        Set<Character> jewelsSet = new HashSet<>((int) (J.length() / 0.75f) + 1);
        int jewelsNum = 0;

        for (char c : J.toCharArray())
            jewelsSet.add(c);
        for (char c : S.toCharArray())
            if (jewelsSet.contains(c)) jewelsNum++;

        return jewelsNum;
    }

}
