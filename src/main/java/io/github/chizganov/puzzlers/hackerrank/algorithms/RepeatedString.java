package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/repeated-string/problem">Repeated String challenge</a>
 *
 * @author Ev Chizganov
 * */
class RepeatedString {

    long repeatedString(String s, long n) {
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

}
