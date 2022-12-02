package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/acm-icpc-team/problem">ACM ICPC Team challenge</a>
 *
 * @author Ev Chizganov
 */
class IcpcTeam {

    int[] acmTeam(String[] topic) {
        int max = 0;
        int count = 0;

        for(int i = 0; i < topic.length - 1; i++) {
            for(int j = i + 1; j < topic.length; j++) {
                final int current = countEqChar(topic[i].toCharArray(), topic[j].toCharArray());
                if(current > max) {
                    max = current;
                    count = 1;
                }
                else if(current == max) count++;
            }
        }

        return new int[]{max, count};
    }

    private int countEqChar(char[] s1, char[] s2) {
        final int l = Math.min(s1.length, s2.length);
        int count = 0;

        for(int i = 0; i < l; i++) {
            if(s1[i] == '1' || s2[i] == '1') count++;
        }

        return count;
    }

}
