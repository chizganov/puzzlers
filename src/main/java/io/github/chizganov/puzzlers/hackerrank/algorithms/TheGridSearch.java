package io.github.chizganov.puzzlers.hackerrank.algorithms;

/**
 * <a href="https://www.hackerrank.com/challenges/the-grid-search/problem">The Grid Search challenge</a>
 *
 * @author Ev Chizganov
 * */
class TheGridSearch {

    /**
     * It should return YES if the pattern exists in the grid, or NO otherwise.
     *
     * @param G the grid to search, an array of strings.
     * @param P the pattern to search for, an array of strings.
     * */
    String gridSearch(String[] G, String[] P) {
        for(int i = 0; i <= G.length - P.length; i++) {
            int e = G[i].indexOf(P[0]);
            while(e != -1) {
                int pi = 1;
                boolean b = true;
                while(pi < P.length) {
                    if(!G[i+pi].startsWith(P[pi], e)) {
                        b = false;
                        break;
                    }
                    pi++;
                }

                if(b) return "YES";
                e = G[i].indexOf(P[0], e + 1);
            }
        }

        return "NO";
    }

}
