package io.github.chizganov.puzzlers.leetcode.thirtyday;

import java.util.List;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/">Leftmost Column with at Least a One challenge</a>
 *
 * @author Ev Chizganov
 */
class LeftmostColumn {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int HEIGHT = binaryMatrix.dimensions().get(0);
        int WIDTH = binaryMatrix.dimensions().get(1);

        int result = -1;

        for (int i = 0; i < HEIGHT; i++) {
            if (binaryMatrix.get(i, WIDTH - 1) == 1) {
                int leftover = findLeftover(binaryMatrix, i, 0, WIDTH - 1);
                if (leftover < result || result == -1) result = leftover;
            }
        }

        return result;
    }

    private int findLeftover(BinaryMatrix bm, int row, int left, int right) {
        if (left == right) return left;

        int mid = (left + right) / 2;
        return bm.get(row, mid) == 1 ? findLeftover(bm, row, left, mid) : findLeftover(bm, row, mid + 1, right);
    }

    static class BinaryMatrix {

        private final int[][] matrix;
        private final List<Integer> dimensions;

        BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
            dimensions = List.of(matrix.length, matrix[0].length);
        }

        int get(int x, int y) {
            return matrix[x][y];
        }

        List<Integer> dimensions() {
            return dimensions;
        }
    }

    static class OptimalSolution extends LeftmostColumn {

        @Override public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            int HEIGHT = binaryMatrix.dimensions().get(0);
            int leftover = binaryMatrix.dimensions().get(1) - 1;
            boolean isFound = false;

            for (int i = 0; i < HEIGHT; i++) {
                if (binaryMatrix.get(i, leftover) == 1) {
                    isFound = true;
                    while (leftover > 0 && binaryMatrix.get(i, leftover - 1) == 1) leftover--;
                }
            }

            return isFound ? leftover : -1;
        }
    }

}
