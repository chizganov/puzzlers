package com.chizganov.puzzlers.leetcode.may;

import com.chizganov.puzzlers.leetcode.util.ListNode;
import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.newBufferedReader;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OddEvenLinkedListTest {

    @ParameterizedTest
    @TestSource(OddEvenLinkedList.class)
    void oddEvenList(OddEvenLinkedList solution, Path input, Path output) throws IOException {
        try (BufferedReader in = newBufferedReader(input);
             BufferedReader out = newBufferedReader(output)) {
            String inLine = in.readLine();
            ListNode inputListHead = ListNode.createFromString(inLine, "->", "NULL");

            ListNode expectedResult = ListNode.createFromString(out.readLine(), "->", "NULL");
            ListNode actualResult = solution.oddEvenList(inputListHead);

            assertEquals(expectedResult, actualResult, String.format("Input list: %s", inputListHead.toString()));
        }
    }
}