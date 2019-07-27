package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* The longest common subsequence (LCS) problem is the problem of finding
* the longest subsequence common to all sequences in a set of sequences
* (often just two sequences).
* It differs from the longest common substring problem.
*
* https://www.hackerrank.com/challenges/common-child/problem?isFullScreen=false
*
* @author Ev Chizganov
* */
public class LCS {

    // Recursion version
    private static int recCommonChild(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) {
            return recCommonChild(
                    s1.substring(0, s1.length()-1),
                    s2.substring(0, s2.length()-1)
            ) + 1;
        }
        else {
            return Math.max(
                    recCommonChild(s1.substring(0, s1.length()-1), s2),
                    recCommonChild(s1, s2.substring(0, s2.length()-1))
            );
        }
    }

    // Non-recursion version - faster
    private static int commonChild(String s1, String s2) {
        int[][] lcs = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    lcs[i+1][j+1] = lcs[i][j] + 1;
                }
                else {
                    lcs[i+1][j+1] = Math.max(lcs[i+1][j], lcs[i][j+1]);
                }
            }
        }

        return lcs[s1.length()][s2.length()];
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);
        System.out.println(result);

        scanner.close();
    }

}
