package com.chizganov.puzzlers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/acm-icpc-team/problem
 *
 * @author Ev Chizganov
 */
public class IcpcTeam {

    // Complete the acmTeam function below.
    private static int[] acmTeam(String[] topic) {
        int max = 0;
        int count = 0;

        for(int i = 0; i < topic.length - 1; i++) {
            for(int j = i + 1; j < topic.length; j++) {
                final int current = countEqChar(topic[i].toCharArray(), topic[j].toCharArray());
                if(current > max) {
                    max = current;
                    count = 1;
                }
                else if(current == max) count++;
            }
        }

        return new int[]{max, count};
    }

    private static int countEqChar(char[] s1, char[] s2) {
        final int l = Math.min(s1.length, s2.length);
        int count = 0;

        for(int i = 0; i < l; i++) {
            if(s1[i] == '1' || s2[i] == '1') count++;
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);
        for(int r : result) System.out.println(r);

        scanner.close();
    }

}
