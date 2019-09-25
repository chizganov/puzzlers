package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HeightOfABinaryTreeTest {

    private static final String PATH = HeightOfABinaryTree.class.getName().replace('.', '/') + "/";
    private static final HeightOfABinaryTree s = new HeightOfABinaryTree();

    @Test void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test04() {
        test("input04.txt", "output04.txt");
    }

    @Test void test05() {
        test("input05.txt", "output05.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HeightOfABinaryTree.Node root = new HeightOfABinaryTree.Node(data[0]);
            for (int i = 1; i < data.length; i++) HeightOfABinaryTree.Node.insert(root, data[i]);

            int result = s.height(root);
            int expResult = exp.nextInt();
            assertEquals(expResult, result);
        }
    }

}