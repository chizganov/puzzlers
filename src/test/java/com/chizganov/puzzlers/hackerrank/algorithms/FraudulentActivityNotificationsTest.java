package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FraudulentActivityNotificationsTest {

    private static final FraudulentActivityNotifications s = new FraudulentActivityNotifications();

    @ParameterizedTest
    @TestSource(FraudulentActivityNotifications.class)
    void activityNotifications(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

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