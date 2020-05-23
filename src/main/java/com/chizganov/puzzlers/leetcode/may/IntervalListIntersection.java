package com.chizganov.puzzlers.leetcode.may;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/">Interval List Intersections problem</a>
 *
 * @author Ev Chizganov
 */
class IntervalListIntersection {

    private static final int START = 0;
    private static final int END = 1;

    int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> joinedIntervals = new ArrayList<>();
        int aIter = 0;
        int bIter = 0;
        while (aIter < a.length && bIter < b.length) {
            int aStart = a[aIter][START];
            int bStart = b[bIter][START];
            int aEnd = a[aIter][END];
            int bEnd = b[bIter][END];

            int start = max(aStart, bStart);
            int end = min(aEnd, bEnd);

            if (aEnd == end) aIter++;
            else bIter++;

            if (start <= end) joinedIntervals.add(new int[]{start, end});
        }

        int[][] result = new int[joinedIntervals.size()][];
        return joinedIntervals.toArray(result);
    }

}
