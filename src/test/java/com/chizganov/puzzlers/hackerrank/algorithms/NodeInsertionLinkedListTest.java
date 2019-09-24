package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NodeInsertionLinkedListTest {

    private static final String PATH = NodeInsertionLinkedList.class.getName().replace('.', '/') + "/";
    private static final NodeInsertionLinkedList s = new NodeInsertionLinkedList();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test01() {
        test("input01.txt", "output01.txt");
    }

    @Test
    void test09() {
        test("input09.txt", "output09.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

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