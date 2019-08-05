package com.chizganov.puzzlers.hackerrank.algorithms;

/**
* Given a set of distinct integers, print the size of a maximal subset of S
* where the sum of any 2 numbers in S' is not evenly divisible by k.
*
* <a href="https://www.hackerrank.com/challenges/non-divisible-subset/problem">Non-Divisible Subset challenge</a>
*
* @author Ev Chizganov
* */
class NonDivisibleSubset {

    int nonDivisibleSubset(int k, int[] s) {
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

}
