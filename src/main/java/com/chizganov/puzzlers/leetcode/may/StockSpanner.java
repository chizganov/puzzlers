package com.chizganov.puzzlers.leetcode.may;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/">Online Stock Span problem</a>
 *
 * @author Ev Chizganov
 */
@SuppressWarnings("unused")
class StockSpanner {

    private final List<Integer> prices;
    private final Deque<Integer> stack;
    private int count = 0;

    StockSpanner() {
        prices = new ArrayList<>();
        stack = new LinkedList<>();
    }

    int next(int price) {
        prices.add(price);

        while (!stack.isEmpty() && prices.get(stack.getLast()) <= price) {
            stack.removeLast();
        }

        int result = stack.isEmpty() ? count + 1 : count - stack.getLast();
        stack.add(count);
        count++;

        return result;
    }

}
