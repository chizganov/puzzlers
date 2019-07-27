package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string/
 *
 * @author Ev Chizganov
 * */
public class RepetedString {

    private static long repeatedString(String s, long n) {
        int mod = (int) (n%s.length());
        long div = n/s.length();

        int i = 0;
        int modCount = 0;
        while(i < mod) {
            if(s.charAt(i) == 'a') modCount++;
            i++;
        }

        long divCount = modCount;
        while(i < s.length()) {
            if(s.charAt(i) == 'a') divCount++;
            i++;
        }

        return (divCount*div) + modCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileInputStream("input.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

        scanner.close();
    }

}
