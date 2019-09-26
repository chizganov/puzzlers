package com.chizganov.puzzlers.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;

/**
 * {@code TestSourceProvider} is an {@code ArgumentsProvider} which uses {@link TestSource}
 * to provide test resources to a {@code @ParameterizedTest} method as a stream of {@code Arguments}.
 * <p>
 * Used as provider of input and expected output test files for testing puzzlers.
 * <p>
 * Example:
 * {@code
 *
 * @ParameterizedTest
 * @TestSource(TestedClass.class) void testSolution(Path input, Path output) {
 * ...
 * }
 * }
 * @see org.junit.jupiter.params.provider.Arguments
 * @see org.junit.jupiter.params.provider.ArgumentsProvider
 * @see org.junit.jupiter.params.ParameterizedTest
 * @see com.chizganov.puzzlers.util.TestSource
 */
public class TestSourceProvider implements ArgumentsProvider, AnnotationConsumer<TestSource> {

    private Class clazz;
    private String testFilePattern;

    @Override public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        Path path = Paths.get(
                requireNonNull(clazz.getClassLoader().getResource(clazz.getName().replace('.', '/') + "/")).toURI()
        );
        Map<Integer, List<Path>> testNumsToPaths;
        try (Stream<Path> files = Files.walk(path)) {
            testNumsToPaths = files
                    .filter(p -> p.getFileName().toString().matches(testFilePattern))
                    .sorted()
                    .collect(groupingBy(p -> Integer.parseInt(p.getFileName().toString().replaceAll("\\D+", ""))));
        }
        if (testNumsToPaths.values().stream().anyMatch(l -> l.size() != 2)) {
            throw new IllegalArgumentException("Invalid number of test files");
        }

        return testNumsToPaths.
                values().stream().map(l -> Arguments.of(l.toArray()));
    }

    @Override public void accept(TestSource testSource) {
        this.clazz = testSource.value();
        this.testFilePattern = testSource.pattern();
    }

}
