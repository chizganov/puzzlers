package io.github.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/">Find the Town Judge problem</a>
 *
 * @author Ev Chizganov
 */
class FindTownJudge {

    int findJudge(int n, int[][] trust) {
        int[] trustToCounts = new int[n + 1];
        int[] trustedByCounts = new int[n + 1];

        for (int[] t : trust) {
            trustToCounts[t[0]]++;
            trustedByCounts[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustToCounts[i] == 0 && trustedByCounts[i] == n - 1) return i;
        }

        return -1;
    }

}
