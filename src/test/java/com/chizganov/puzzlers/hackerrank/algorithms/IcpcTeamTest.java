package com.chizganov.puzzlers.hackerrank.algorithms;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IcpcTeamTest {

    private static final IcpcTeam s = new IcpcTeam();

    @ParameterizedTest
    @TestSource(IcpcTeam.class)
    void acmTeam(Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream expStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner exp = new Scanner(expStream)) {

            String[] nm = in.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);

            String[] topic = new String[n];

            for (int i = 0; i < n; i++) {
                String topicItem = in.nextLine();
                topic[i] = topicItem;
            }

            int[] result = s.acmTeam(topic);
            for (int r : result) {
                int expResult = Integer.parseInt(exp.nextLine());
                assertEquals(expResult, r);
            }
        }
    }

}
