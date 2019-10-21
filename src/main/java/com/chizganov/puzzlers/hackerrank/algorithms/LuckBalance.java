package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/luck-balance/problem">Luke Balance challenge</a>
 *
 * @author Ev Chizganov
 */
class LuckBalance {

    int luckBalance(int k, int[][] contests) {
        List<Integer> importantContests = new ArrayList<>();
        int sum = 0;

        for (int[] contest : contests) {
            sum += contest[0];
            if (contest[1] == 1) importantContests.add(contest[0]);
        }

        importantContests.sort((x, y) -> Integer.compare(y, x));
        for (int loseCount = importantContests.size() - k; loseCount > 0; loseCount--)
            sum -= importantContests.remove(importantContests.size() - 1) * 2;

        return sum;
    }

}
