package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/frequency-queries/problem">Frequency Queries challenge</a>
 *
 * @author Ev Chizganov
 */
class FrequencyQueries {

    List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> frequencies = new ArrayList<>();
        for (List<Integer> q : queries) {
            int param = q.get(1);
            switch (q.get(0)) {
                case 1:
                    map.merge(param, 1, (oldVal, newVal) -> ++oldVal);
                    break;
                case 2:
                    map.computeIfPresent(param, (key, value) -> value == 1 ? null : value - 1);
                    break;
                case 3:
                    if (map.containsValue(param)) frequencies.add(1);
                    else frequencies.add(0);
                    break;
            }
        }

        return frequencies;
    }

}
