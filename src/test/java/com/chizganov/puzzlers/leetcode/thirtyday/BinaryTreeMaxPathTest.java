package com.chizganov.puzzlers.leetcode.thirtyday;

import com.chizganov.puzzlers.leetcode.util.TreeNode;
import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.chizganov.puzzlers.leetcode.util.TreeNode.createBinaryTreeFromBfsString;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeMaxPathTest {

    @ParameterizedTest
    @TestSource(BinaryTreeMaxPath.class)
    void maxPathSum(BinaryTreeMaxPath solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            String bfsString = in.readLine();
            TreeNode tree = createBinaryTreeFromBfsString(bfsString, ",", "null");

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.maxPathSum(tree);

            assertEquals(expectedResult, actualResult);
        }
    }
}