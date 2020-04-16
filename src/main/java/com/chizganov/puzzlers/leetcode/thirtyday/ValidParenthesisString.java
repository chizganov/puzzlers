package com.chizganov.puzzlers.leetcode.thirtyday;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3301/">Valid Parenthesis String challenge</a>
 *
 * @author Ev Chizganov
 */
class ValidParenthesisString {

    boolean checkValidString(String s) {
        List<Character> simplifiedString = new LinkedList<>();
        Deque<Integer> openBracketIndices = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !openBracketIndices.isEmpty())
                simplifiedString.remove((int) openBracketIndices.removeLast());
            else simplifiedString.add(c);
            if (c == '(') openBracketIndices.addLast(simplifiedString.size() - 1);
        }

        int starsCount = 0;
        int openBracketsCount = 0;
        for (char c : simplifiedString) {
            if (c == '(') openBracketsCount++;
            if (c == '*') {
                if (openBracketsCount > 0) openBracketsCount--;
                else starsCount++;
            }
            if (c == ')') starsCount--;
            if (starsCount < 0) return false;
        }

        return openBracketsCount == 0;
    }

}
