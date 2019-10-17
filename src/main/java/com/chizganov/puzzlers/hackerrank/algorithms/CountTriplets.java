package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.reverse;

/**
 * <a href="https://www.hackerrank.com/challenges/count-triplets-1/problem">Count Triplets challenge</a>
 *
 * @author Ev Chizganov
 */
class CountTriplets {

    long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> occurrences = new HashMap<>();
        // contains pair occurrences as index of first element
        Map<Long, Long> pairs = new HashMap<>();
        long count = 0L;

        reverse(arr);
        for (long b : arr) {
            long next = b * r;
            if (pairs.containsKey(next)) count += pairs.get(next);
            if (occurrences.containsKey(next))
                pairs.merge(b, occurrences.get(next), (oldVal, newVal) -> oldVal += newVal);

            occurrences.merge(b, 1L, (oldVal, newVal) -> oldVal += newVal);
        }

        return count;
    }

}
