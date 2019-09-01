package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/2d-array/problem">2D Array - DS challenge</a>
 *
 * @author Ev Chizganov
 * */
class TwoDArray {

    int hourglassSum(int[][] arr) {
        final int HG_LINE = arr.length - 2;
        final int HG_COUNT = HG_LINE * HG_LINE;
        int maxSum = -100;
        for(int i = 0; i < HG_COUNT; i++) {
            int sum = 0;
            // r - row, c - column
            int r = i / (HG_LINE);
            int c = i % (HG_LINE);
            /*
            * a[1]+a[2]+a[3]+
            *      a[4]+
            * a[5]+a[6]+a[7]
            * */
            sum += arr[r][c] + arr[r][c+1] + arr[r][c+2] +
                    arr[r+1][c+1] +
                    arr[r+2][c] + arr[r+2][c+1] + arr[r+2][c+2];
            if(sum > maxSum) maxSum = sum;
        }

        return maxSum;
    }

}
