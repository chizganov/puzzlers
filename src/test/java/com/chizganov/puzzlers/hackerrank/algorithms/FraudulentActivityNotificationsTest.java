package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FraudulentActivityNotificationsTest {

    private static final String PATH = FraudulentActivityNotifications.class.getName().replace('.', '/') + "/";
    private static final FraudulentActivityNotifications s = new FraudulentActivityNotifications();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test
    void test06() {
        test("input06.txt", "output06.txt");
    }

    @Test
    void test07() {
        test("input07.txt", "output07.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {
            int d = Integer.parseInt(in.nextLine().split(" ")[1]);
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] expenditure = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int result = s.activityNotifications(expenditure, d);
            int expResult = Integer.parseInt(exp.nextLine());
            assertEquals(expResult, result);
        }
    }


}