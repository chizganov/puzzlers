package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem">Queues: A Tale of Two Stacks challenge</a>
 *
 * @author Ev Chizganov
 */
@SuppressWarnings("UnusedReturnValue")
class QueueTwoStacks<T> {

    private final Stack<T> direct = new Stack<>();
    private final Stack<T> reverse = new Stack<>();

    void enqueue(T e) {
        direct.push(e);
    }

    T dequeue() {
        if (reverse.isEmpty())
            while (!direct.isEmpty()) reverse.push(direct.pop());

        return reverse.pop();
    }

    T peek() {
        if (reverse.isEmpty())
            while (!direct.isEmpty()) reverse.push(direct.pop());

        return reverse.peek();
    }

}
