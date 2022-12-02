package io.github.chizganov.puzzlers.hackerrank.algorithms;

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

    List<Integer> freqQuery(List<int[]> queries) {
        Map<Integer, Integer> valToOccurrences = new HashMap<>();
        Map<Integer, Integer> occurrencesToValCount = new HashMap<>();
        List<Integer> frequencies = new ArrayList<>();
        for (int[] q : queries) {
            int param = q[1];
            switch (q[0]) {
                case 1:
                    int occurrence = valToOccurrences.getOrDefault(param, 0);
                    occurrencesToValCount.computeIfPresent(occurrence, (key, value) -> value == 1 ? null : value - 1);
                    valToOccurrences.put(param, ++occurrence);
                    occurrencesToValCount.merge(occurrence, 1, (oldVal, newVal) -> ++oldVal);
                    break;
                case 2:
                    occurrence = valToOccurrences.getOrDefault(param, 0);
                    occurrencesToValCount.computeIfPresent(occurrence, (key, value) -> value == 1 ? null : value - 1);
                    valToOccurrences.computeIfPresent(param, (key, value) -> value == 1 ? null : value - 1);
                    if (--occurrence >= 0) occurrencesToValCount.merge(occurrence, 1, (oldVal, newVal) -> ++oldVal);
                    break;
                case 3:
                    if (occurrencesToValCount.containsKey(param)) frequencies.add(1);
                    else frequencies.add(0);
                    break;
            }
        }

        return frequencies;
    }

}
