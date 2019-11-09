package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/balanced-brackets/problem">Balanced Brackets challenge</a>
 *
 * @author Ev Chizganov
 */
class BalancedBrackets {

    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final Map<Character, Character> brackets = initBracketsMap();

    String isBalanced(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) deque.addLast(c);
            else if (deque.isEmpty() || c != brackets.get(deque.pollLast())) return NO;
        }

        return deque.isEmpty() ? YES : NO;
    }

    private static Map<Character, Character> initBracketsMap() {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');

        return Collections.unmodifiableMap(brackets);
    }

}
