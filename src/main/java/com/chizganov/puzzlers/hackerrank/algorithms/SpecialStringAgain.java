package com.chizganov.puzzlers.hackerrank.algorithms;

import java.util.HashMap;
import java.util.Map;

class SpecialStringAgain {

    long substrCount(int n, String s) {
        Map<String, Long> map = new HashMap<>();
        for (int k = 1; k <= n; k++)
            for (int i = 0; i <= n - k; i++) {
                String sub = s.substring(i, i + k);
                if (isValid(sub))
                    map.merge(sub, 1L, Long::sum);
            }

        return map.values().stream().mapToLong(v -> v).sum();
    }

    private boolean isValid(String s) {
        char[] chrs = s.toCharArray();
        char expected = chrs[0];

        int i;
        for (i = 1; i < s.length() / 2; i++) {
            if (chrs[i] != expected) return false;
        }
        for (i = s.length() % 2 == 0 ? i : i + 1; i < s.length(); i++)
            if (chrs[i] != expected) return false;

        return true;
    }

}
