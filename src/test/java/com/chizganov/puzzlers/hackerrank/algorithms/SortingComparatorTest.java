package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static com.chizganov.puzzlers.hackerrank.algorithms.SortingComparator.Player;

class SortingComparatorTest {

    private static final String PATH = SortingComparator.class.getName().replace('.', '/') + "/";
    private static final SortingComparator s = new SortingComparator();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test06() {
        test("input06.txt", "output06.txt");
    }

    @Test
    void test07() {
        test("input07.txt", "output07.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            int n = in.nextInt();
            Player[] players = new Player[n];
            Player[] expPlayers = new Player[n];

            for (int i = 0; i < n; i++) {
                players[i] = new Player(in.next(), in.nextInt());
                expPlayers[i] = new Player(exp.next(), exp.nextInt());
            }

            Arrays.sort(players, s);
            assertArrayEquals(expPlayers, players);
        }
    }

}