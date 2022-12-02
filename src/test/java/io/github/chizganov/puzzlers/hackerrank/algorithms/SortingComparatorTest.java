package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static io.github.chizganov.puzzlers.hackerrank.algorithms.SortingComparator.Player;
import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingComparatorTest {

    @ParameterizedTest
    @TestSource(SortingComparator.class)
    void compare(SortingComparator solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int n = in.nextInt();

            Player[] players = new Player[n];
            Player[] expPlayers = new Player[n];

            for (int i = 0; i < n; i++) {
                players[i] = new Player(in.next(), in.nextInt());
                expPlayers[i] = new Player(exp.next(), exp.nextInt());
            }

            Arrays.sort(players, solution);
            assertArrayEquals(expPlayers, players);
        }
    }

}