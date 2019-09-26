package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NodeInsertionLinkedListTest {

    private static final NodeInsertionLinkedList s = new NodeInsertionLinkedList();

    @ParameterizedTest
    @TestSource(NodeInsertionLinkedList.class)
    void insertNodeAtPosition(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            int n = in.nextInt();
            int[] data = new int[n];

            for (int i = 0; i < n; i++) data[i] = in.nextInt();

            int node = in.nextInt();
            int position = in.nextInt();

            NodeInsertionLinkedList.SinglyLinkedListNode head = NodeInsertionLinkedList.SinglyLinkedListNode.create(data);

            int[] result = s.insertNodeAtPosition(head, node, position).array();
            int[] expResult = Arrays.stream(exp.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assertArrayEquals(expResult, result);
        }
    }

}