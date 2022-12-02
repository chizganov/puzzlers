package io.github.chizganov.puzzlers.leetcode.may;

import static java.lang.Math.min;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/">Count Square Submatrices with All Ones problem</a>
 *
 * @author Ev Chizganov
 */
class CountSquareSubmatrices {

    int countSquares(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int squareCount = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int squareSize = 0;
                boolean valid = true;
                while (valid && i + squareSize < height && j + squareSize < width) {
                    for (int outlineIter = 0; outlineIter <= squareSize; outlineIter++) {
                        if (matrix[i + outlineIter][j + squareSize] != 1 ||
                                matrix[i + squareSize][j + outlineIter] != 1) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) squareCount++;
                    squareSize++;
                }
            }
        }

        return squareCount;
    }

    static class EffectiveSolution extends CountSquareSubmatrices {

        @Override int countSquares(int[][] matrix) {
            int height = matrix.length;
            int width = matrix[0].length;

            int squareCount = matrix[0][0];

            for (int i = 1; i < height; i++) {
                squareCount += matrix[i][0];
            }
            for (int j = 1; j < width; j++) {
                squareCount += matrix[0][j];
            }
            for (int i = 1; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] = min(matrix[i - 1][j - 1], min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                        squareCount += matrix[i][j];
                    }
                }
            }

            return squareCount;
        }
    }

}
