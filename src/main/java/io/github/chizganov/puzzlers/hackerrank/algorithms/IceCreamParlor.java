package io.github.chizganov.puzzlers.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem">Hash Tables: Ice Cream Parlor challenge</a>
 *
 * @author Ev Chizganov
 */
class IceCreamParlor {

    int[] whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> costToIndex = new HashMap<>();
        int[] halfIndices = new int[2];
        for (int i = 0; i < cost.length; i++) {
            costToIndex.put(cost[i], i + 1);
            if (money % 2 == 0 && cost[i] == money / 2) {
                if (halfIndices[0] == 0) halfIndices[0] = i + 1;
                else if (halfIndices[1] == 0) halfIndices[1] = i + 1;
            }
        }

        for (int i = 1; i <= cost.length; i++) {
            int c1 = cost[i - 1];
            int c2 = money - c1;
            if (c1 == c2 && halfIndices[1] != 0)
                return halfIndices;
            if (c1 != c2 && costToIndex.containsKey(c1) && costToIndex.containsKey(c2))
                return new int[]{costToIndex.get(c1), costToIndex.get(c2)};
        }

        return new int[0];
    }

}
