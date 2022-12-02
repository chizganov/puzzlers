package io.github.chizganov.puzzlers.leetcode.may;

import io.github.chizganov.puzzlers.leetcode.util.TreeNode;
import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CousinsInBinaryTreeTest {

    @ParameterizedTest
    @TestSource(CousinsInBinaryTree.class)
    void isCousins(CousinsInBinaryTree solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String btreeString = in.readLine();
            TreeNode btree = TreeNode.createBinaryTreeFromBfsString(btreeString, ",", "null");
            int x = parseInt(in.readLine());
            int y = parseInt(in.readLine());

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.isCousins(btree, x, y);

            assertEquals(expectedResult, actualResult,
                    String.format("Input: tree [%s], x = %d, y = %d", btree, x, y));
        }
    }
}