package io.github.chizganov.puzzlers.hackerrank.algorithms;

import java.util.*;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-ransom-note/problem">Hash Tables: Ransom Note challenge</a>
 *
 * @author Ev Chizganov
 */
class RansomNote {

    boolean checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String m : magazine) {
            Integer o = occurrences.get(m);
            if (o != null)
                occurrences.put(m, ++o);
            else
                occurrences.put(m, 1);
        }
        for (String n : note) {
            Integer count = occurrences.get(n);
            if (count == null || count == 0) return false;
            occurrences.replace(n, --count);
        }

        return true;
    }

    static class ListSolution extends RansomNote {

        @Override
        boolean checkMagazine(String[] magazine, String[] note) {
            Arrays.sort(magazine);
            Arrays.sort(note);

            List<String> mList = new ArrayList<>(Arrays.asList(magazine));
            for (String n : note) if (!mList.remove(n)) return false;

            return true;
        }
    }

}
