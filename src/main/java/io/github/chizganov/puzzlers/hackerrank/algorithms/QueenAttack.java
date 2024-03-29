package io.github.chizganov.puzzlers.hackerrank.algorithms;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

/**
 * <a href="https://www.hackerrank.com/challenges/queens-attack-2/problem">Queens Attack challenge</a>
 *
 * @author Ev Chizganov
 */
class QueenAttack {

    private static final int Y = 0;
    private static final int X = 1;

    int queensAttack(int n, int r_q, int c_q, int[][] obstacles) {
        // closest obstacles to queen
        int[] closest = new int[8];

        for (int i = 0; i < 4; i++) {
            closest[i] = Integer.MAX_VALUE;
            closest[4 + i] = Integer.MIN_VALUE;
        }
        for (int[] oCoords : obstacles) {
            int[] dif = new int[2];
            dif[Y] = oCoords[Y] - r_q;
            dif[X] = oCoords[X] - c_q;
            // Recognize direction from N to NW (from 0 to 7)
            boolean isDiagonal = abs(dif[Y]) == abs(dif[X]);
            if (dif[Y] > 0 && dif[X] == 0 && dif[Y] < closest[0]) closest[0] = dif[Y];
            else if (dif[Y] > 0 && dif[X] > 0 && isDiagonal && dif[Y] < closest[1]) closest[1] = dif[Y];
            else if (dif[Y] == 0 && dif[X] > 0 && dif[X] < closest[2]) closest[2] = dif[X];
            else if (dif[Y] < 0 && dif[X] > 0 && isDiagonal && dif[X] < closest[3]) closest[3] = dif[X];
            else if (dif[Y] < 0 && dif[X] == 0 && dif[Y] > closest[4]) closest[4] = dif[Y];
            else if (dif[Y] < 0 && dif[X] < 0 && isDiagonal && dif[Y] > closest[5]) closest[5] = dif[Y];
            else if (dif[Y] == 0 && dif[X] < 0 && dif[X] > closest[6]) closest[6] = dif[X];
            else if (dif[Y] > 0 && dif[X] < 0 && isDiagonal && dif[X] > closest[7]) closest[7] = dif[X];
        }

        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (closest[i] == Integer.MAX_VALUE || closest[i] == Integer.MIN_VALUE) {
                if (i % 2 == 0) count += getDistance(n, r_q, c_q, i);
                else count += min(getDistance(n, r_q, c_q, i - 1), getDistance(n, r_q, c_q, (i + 1) % 8));
            } else {
                count += abs(closest[i]) - 1;
            }
        }

        return count;
    }

    private static int getDistance(int n, int r_q, int c_q, int dis) {
        if (dis == 0) return n - r_q;
        else if (dis == 2) return n - c_q;
        else if (dis == 4) return r_q - 1;
        else if (dis == 6) return c_q - 1;

        return 0;
    }

}
