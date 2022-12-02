package io.github.chizganov.puzzlers.leetcode.thirtyday;

import io.github.chizganov.puzzlers.leetcode.util.TreeNode;
import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static io.github.chizganov.puzzlers.leetcode.util.TreeNode.createBinaryTreeFromBfsString;
import static java.lang.Boolean.parseBoolean;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringIsValidSeqInBinaryTreeTest {

    @ParameterizedTest
    @TestSource(StringIsValidSeqInBinaryTree.class)
    void isValidSequence(StringIsValidSeqInBinaryTree solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            String btreeString = in.readLine();
            TreeNode btree = createBinaryTreeFromBfsString(btreeString, ",", "null");
            int[] arr = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

            boolean expectedResult = parseBoolean(out.readLine());
            boolean actualResult = solution.isValidSequence(btree, arr);

            assertEquals(expectedResult, actualResult,
                    String.format("Input binary tree: %s; input number array: %s", btreeString, Arrays.toString(arr))
            );
        }
    }
}