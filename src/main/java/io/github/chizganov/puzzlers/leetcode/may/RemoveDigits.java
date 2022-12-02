package io.github.chizganov.puzzlers.leetcode.may;

/**
 * <a href="https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/">Remove K Digits problem</a>
 *
 * @author Ev Chizganov
 */
class RemoveDigits {

    String removeKdigits(String num, int k) {
        int size = num.length() - k;
        char[] buffer = new char[size];

        for (int i = 0; i < size; i++) {
            buffer[i] = num.charAt(k + i);
        }
        for (int i = k - 1; i >= 0; i--) {
            char replacement = num.charAt(i);
            int position = 0;
            while (position < size && buffer[position] >= replacement) {
                char t = buffer[position];
                buffer[position] = replacement;
                replacement = t;
                position++;
            }
        }

        int startIndex = 0;
        while (startIndex < size && buffer[startIndex] == '0') startIndex++;

        return startIndex != size ? String.valueOf(buffer, startIndex, size - startIndex) : "0";
    }

}
