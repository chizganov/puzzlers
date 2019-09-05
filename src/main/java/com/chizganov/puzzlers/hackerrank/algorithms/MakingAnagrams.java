package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-making-anagrams/problem">Making Anagrams challenge</a>
 *
 * @author Ev Chizganov
 * */
class MakingAnagrams {

    int makeAnagram(String a, String b) {
        int[] alphabet = new int[26];
        for(char c : a.toCharArray()) alphabet[c-'a']++;
        for(char c : b.toCharArray()) alphabet[c-'a']--;
        int count = 0;
        for(int c : alphabet) count += Math.abs(c);

        return count;
    }

}
