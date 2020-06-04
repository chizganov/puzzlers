package com.chizganov.puzzlers.leetcode.may;

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

}
