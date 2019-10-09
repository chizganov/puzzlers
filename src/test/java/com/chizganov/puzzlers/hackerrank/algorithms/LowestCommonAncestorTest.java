package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LowestCommonAncestorTest {

    private static LowestCommonAncestor s = new LowestCommonAncestor();

    @ParameterizedTest
    @TestSource(LowestCommonAncestor.class)
    void lca(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {

            in.skip("\\d+(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            LowestCommonAncestor.Node root = null;
            for (int d : data) {
                root = LowestCommonAncestor.Node.insert(root, d);
            }
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            int actualResult = s.lca(root, v1, v2).getData();
            int expectedResult = out.nextInt();
            assertEquals(expectedResult, actualResult);
        }
    }

}