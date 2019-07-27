package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
* Given a set of distinct integers, print the size of a maximal subset of S
* where the sum of any 2 numbers in S' is not evenly divisible by k.
*
* https://www.hackerrank.com/challenges/non-divisible-subset/problem
*
* @author Ev Chizganov
* */
public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    private static int nonDivisibleSubset(int k, int[] s) {
        /*
        * a+b%k=0 <=> a%k + b%k = k (or 0)
        * */
        // reminders of division to k
        int[] mod = new int[k];

        // count reminders
        for(int e : s) {
            mod[e%k]++;
        }

        // even or odd
        int end = k%2 == 0 ? k/2-1 : k/2;
        // 1: even or odd; 2: has middle reminder
        int count = k%2 == 0 ? (mod[end+1] != 0 ? 1 : 0) : 0;
        if(mod[0] != 0) count++;
        // add max from sum pair
        for(int i = 1; i <= end; i++) {
            count += Math.max(mod[i], mod[k-i]);
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        System.out.println(result);

        scanner.close();
    }
}
