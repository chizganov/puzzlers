package com.chizganov.puzzlers.hackerrank.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 *
 * @author Ev Chizganov
 * */
public class TheGridSearch {

    private static String gridSearch(String[] G, String[] P) {
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

    public static void main(String[] args) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(new File("input.txt"))) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String[] RC = scanner.nextLine().split(" ");

                int R = Integer.parseInt(RC[0]);

                int C = Integer.parseInt(RC[1]);

                String[] G = new String[R];

                for (int i = 0; i < R; i++) {
                    String GItem = scanner.nextLine();
                    G[i] = GItem;
                }

                String[] rc = scanner.nextLine().split(" ");

                int r = Integer.parseInt(rc[0]);

                int c = Integer.parseInt(rc[1]);

                String[] P = new String[r];

                for (int i = 0; i < r; i++) {
                    String PItem = scanner.nextLine();
                    P[i] = PItem;
                }

                String result = gridSearch(G, P);

                System.out.println(result);
            }
        }
    }

}
