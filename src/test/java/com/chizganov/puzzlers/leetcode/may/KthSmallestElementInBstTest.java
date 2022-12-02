package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.leetcode.util.TreeNode;
import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KthSmallestElementInBstTest {

    @ParameterizedTest
    @TestSource(KthSmallestElementInBst.class)
    void kthSmallest(KthSmallestElementInBst solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String btreeString = in.readLine().replaceAll("(^\\D*|\\D*$)", "");
            int k = parseInt(in.readLine());

            TreeNode root = TreeNode.createBinaryTreeFromBfsString(btreeString, ",", "null");

            int expectedResult = parseInt(out.readLine());
            int actualResult = solution.kthSmallest(root, k);

            assertEquals(expectedResult, actualResult, String.format("Input: bst = [%s], k = %d", btreeString, k));
        }
    }
}