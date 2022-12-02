package io.github.chizganov.puzzlers.hackerrank.algorithms;

import io.github.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.newInputStream;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountTripletsTest {

    @ParameterizedTest
    @TestSource(CountTriplets.class)
    void countTriplets(CountTriplets solution, Path input, Path output) throws IOException {
        InputStream inStream = newInputStream(input);
        InputStream outStream = newInputStream(output);

        try (Scanner in = new Scanner(inStream);
             Scanner out = new Scanner(outStream)) {
            in.nextInt();
            int r = in.nextInt();
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<Long> arr = Arrays.stream(in.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .boxed()
                    .collect(toList());

            Long actualResult = solution.countTriplets(arr, r);
            Long expectedResult = out.nextLong();

            assertEquals(expectedResult, actualResult);
        }
    }

}