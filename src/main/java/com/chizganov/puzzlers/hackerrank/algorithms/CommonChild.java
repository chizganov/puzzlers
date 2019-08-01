package com.chizganov.puzzlers.hackerrank.algorithms;

/*
* The longest common subsequence (LCS) problem is the problem of finding
* the longest subsequence common to all sequences in a set of sequences
* (often just two sequences).
* It differs from the longest common substring problem.
*
* <a href="https://www.hackerrank.com/challenges/common-child/problem">Common Child challenge</a>
*
* @author Ev Chizganov
* */
class CommonChild {

    // Recursion version
    @SuppressWarnings({"unused", "WeakerAccess"})
    int recCommonChild(String s1, String s2) {
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
    int commonChild(String s1, String s2) {
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

}
