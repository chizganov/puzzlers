package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 *
 * @author Ev Chizganov
 * */
public class BiggerIsGreater {

    private static String biggerIsGreater(String w) {
        /*
        * Use next lexicographical algorithm:
        * 1) Find largest index i such that array[i − 1] < array[i].
        *   (If no such i exists, then this is already the last permutation.)
        * 2) Find largest index j such that j ≥ i and array[j] > array[i − 1].
        * 3) Swap array[j] and array[i − 1].
        * 4) Reverse the suffix starting at array[i].
        * */
        final int l = w.length();
        final String na = "no answer";

        if(l <= 1) return na;

        // Find pivot index
        int i = l - 2;
        while(i >= 0 && w.charAt(i) >= w.charAt(i+1)) i--;
        if(i < 0) return na;

        final int pivot = i;
        final char[] prefix = w.substring(0, pivot + 1).toCharArray();
        final char[] suffix = w.substring(pivot + 1, l).toCharArray();
        // Find pivot position (i-1)
        i = 0;
        while(i < suffix.length && prefix[pivot] < suffix[i]) i++;
        // Swap
        final char c = prefix[pivot];
        prefix[pivot] = suffix[i-1];
        suffix[i-1] = c;

        return String.valueOf(prefix) + new StringBuilder().append(suffix).reverse().toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            System.out.println(result);
        }

        scanner.close();
    }
}
