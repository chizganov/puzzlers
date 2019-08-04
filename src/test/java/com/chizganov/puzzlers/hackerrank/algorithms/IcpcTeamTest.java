package com.chizganov.puzzlers.hackerrank.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

class IcpcTeamTest {

    private static final String PATH = IcpcTeam.class.getName().replace('.', '/') + "/";
    private static final IcpcTeam c = new IcpcTeam();

    @Test
    void test00() {
        test("input00.txt", "output00.txt");
    }

    @Test void test08() {
        test("input08.txt", "output08.txt");
    }

    void test(String inFile, String expFile) {
        InputStream inStream = getClass().getClassLoader().getResourceAsStream(PATH + "input/" + inFile);
        InputStream expStream = getClass().getClassLoader().getResourceAsStream(PATH + "output/" + expFile);
        assert inStream != null;
        assert expStream != null;

        try(Scanner in = new Scanner(inStream);
            Scanner exp = new Scanner(expStream)) {

            String[] nm = in.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] topic = new String[n];

            for (int i = 0; i < n; i++) {
                String topicItem = in.nextLine();
                topic[i] = topicItem;
            }

            int[] result = c.acmTeam(topic);
            for(int r : result) {
                int expResult = Integer.parseInt(exp.nextLine());
                Assertions.assertEquals(expResult, r);
            }
        }
    }

}
