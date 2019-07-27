package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 *
 * @author Ev Chizganov
 * */
public class BallContainer {

    // Complete the organizingContainers function below.
    private static String organizingContainers(int[][] container) {
        /*
        * 1) Calculate tne capacity and ball of appropriate type
        * 2) Sort capacity and balls
        * 3) Possible if equals, Impossible otherwise
        * */
        int length = container.length;
        int[] capacity = new int[length];
        int[] ballCount = new int[length];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                capacity[i] += container[i][j];
                ballCount[j] += container[i][j];
            }
        }

        Arrays.sort(capacity);
        Arrays.sort(ballCount);

        if(Arrays.equals(capacity, ballCount)) return "Possible";

        return "Impossible";
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            System.out.println(result);
        }

        scanner.close();
    }

}
