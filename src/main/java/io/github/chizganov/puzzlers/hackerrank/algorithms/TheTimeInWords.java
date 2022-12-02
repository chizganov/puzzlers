package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/the-time-in-words/problem">The Time In Words challenge</a>
 *
 * @author Ev Chizganov
 * */
class TheTimeInWords {

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

    String timeInWords(int h, int m) {
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

}
