package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/sock-merchant/problem">Sock Merchant challenge</a>
 *
 * @author Ev Chizganov
 * */
class SockMerchant {

    int sockMerchant(int[] ar) {
        byte[] colors = new byte[100];
        for(int e : ar) {
            colors[e-1]++;
        }
        byte result = 0;
        for(byte c : colors) {
            result += (byte)(c >>> 1);
        }

        return result;
    }

}
