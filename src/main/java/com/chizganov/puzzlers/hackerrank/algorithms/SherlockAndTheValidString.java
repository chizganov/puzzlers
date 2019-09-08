package com.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem">Sherlock and the Valid String challenge</a>
 *
 * @author Ev Chizganov
 * */
class SherlockAndTheValidString {

    String isValid(String s) {
        int[] alphabet = new int[26];
        for(char c : s.toCharArray()) alphabet[c -'a']++;

        int minIndex = 0;
        for(int i = 0; i < alphabet.length - 1; i++) {
            for(int j = alphabet.length - 1; j > i; j--) {
                if(alphabet[j] < alphabet[j-1]) {
                    int temp = alphabet[j];
                    alphabet[j] = alphabet[j-1];
                    alphabet[j-1] = temp;
                }
            }
            if(alphabet[i] == 0) minIndex++;
        }
        int min = alphabet[minIndex];
        int max = alphabet[alphabet.length-1];

        if(min == max) return "YES";
        if(((max - min == 1) && (max > alphabet[alphabet.length-2])) ||
                (min == 1) && (alphabet[minIndex+1] == max)) {
            return "YES";
        }

        return "NO";
    }

}
