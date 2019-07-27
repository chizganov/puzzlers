package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* https://www.hackerrank.com/challenges/queens-attack-2/problem
*
* @author Ev Chizganov
* */
public class QueenAttack {

    private static final int Y = 0;
    private static final int X = 1;

    // Complete the queensAttack function below.
    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // closest obstacles to queen
        int[] closest = new int[8];
        for(int i = 0; i < 4; i++) {
            closest[i] = Integer.MAX_VALUE;
            closest[4+i] = Integer.MIN_VALUE;
        }
        for(int[] oCoords : obstacles) {
            int[] dif = new int[2];
            // y dif
            dif[Y] = oCoords[Y] - r_q;
            // x dif
            dif[X] = oCoords[X] - c_q;
            // Recognize direction from N to NW (from 0 to 7)
            if(dif[Y] > 0 && dif[X] == 0 && dif[Y] < closest[0]) closest[0] = dif[Y];
            else if(dif[Y] > 0 && dif[X] > 0 && Math.abs(dif[Y]) == Math.abs(dif[X]) && dif[Y] < closest[1]) closest[1] = dif[Y];
            else if(dif[Y] == 0 && dif[X] > 0 && dif[X] < closest[2]) closest[2] = dif[X];
            else if(dif[Y] < 0 && dif[X] > 0 && Math.abs(dif[Y]) == Math.abs(dif[X]) && dif[X] < closest[3]) closest[3] = dif[X];
            else if(dif[Y] < 0 && dif[X] == 0 && dif[Y] > closest[4]) closest[4] = dif[Y];
            else if(dif[Y] < 0 && dif[X] < 0 && Math.abs(dif[Y]) == Math.abs(dif[X]) && dif[Y] > closest[5]) closest[5] = dif[Y];
            else if(dif[Y] == 0 && dif[X] < 0 && dif[X] > closest[6]) closest[6] = dif[X];
            else if(dif[Y] > 0 && dif[X] < 0 && Math.abs(dif[Y]) == Math.abs(dif[X]) && dif[X] > closest[7]) closest[7] = dif[X];
        }

        int count = 0;
        for(int i = 0; i < 8; i++) {
            if(closest[i] == Integer.MAX_VALUE || closest[i] == Integer.MIN_VALUE) {
                if(i%2 == 0) count += getDistance(n, r_q, c_q, i);
                else count += Math.min(getDistance(n, r_q, c_q, i-1), getDistance(n, r_q, c_q, (i+1)%8));
            }
            else {
                count += Math.abs(closest[i]) - 1;
            }
        }

        return count;
    }

    private static int getDistance(int n, int r_q, int c_q, int dis) {
        if(dis == 0) return n - r_q;
        else if(dis == 2) return n - c_q;
        else if(dis == 4) return r_q - 1;
        else if(dis == 6) return c_q - 1;

        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(result);

        scanner.close();
    }

}
