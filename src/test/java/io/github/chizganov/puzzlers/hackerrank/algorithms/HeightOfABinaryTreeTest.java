package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HeightOfABinaryTreeTest {

    @ParameterizedTest
    @TestSource(HeightOfABinaryTree.class)
    void height(HeightOfABinaryTree solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            HeightOfABinaryTree.Node root = new HeightOfABinaryTree.Node(data[0]);
            for (int i = 1; i < data.length; i++) HeightOfABinaryTree.Node.insert(root, data[i]);

            int result = solution.height(root);
            int expResult = exp.nextInt();
            assertEquals(expResult, result);
        }
    }

}