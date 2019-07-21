package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TheTimeInWords {

    private static final String[] d = new String[] {
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "quarter",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen",
        "twenty"
    };

    private static String timeInWords(int h, int m) {
        if(m == 0) return d[h] + " o' clock";
        if(m == 30) return "half past " + d[h];
        if(m == 15) return "quarter past " + d[h];
        if(m == 45) return "quarter to " + d[++h];
        String half = "past";
        if(m > 30) {
            m = 60 - m;
            h++;
            half = "to";
        }
        if(m == 1) return d[m] + " minute " + half + " " + d[h];
        String min;
        if(m < 20) {
            min = d[m];
        } else {
            min = d[m-(m%10)];
            if(m%10 != 0) min += " " + d[m%10];
        }
        return min + " minutes " + half + " " + d[h];
    }

    public static void main(String[] args) throws IOException {
        final Scanner scanner = new Scanner(new File("input.txt"));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        System.out.println(result);

        scanner.close();
    }

}
