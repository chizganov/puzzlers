package io.github.chizganov.puzzlers.util;

import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.System.arraycopy;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * {@code TestSourceProvider} is an {@link ArgumentsProvider} which uses {@link TestSource}
 * to provide test resources to a {@link org.junit.jupiter.params.ParameterizedTest} method as a stream of {@link Arguments}.
 * <p>
 * Used as a provider of class instance and resources for testing.
 * <p>
 * <p>
 * Example:
 * <blockquote><pre>
 * {@literal @}ParameterizedTest
 * {@literal @}TestSource(TestedClass.class)
 *  void testSolution(TestedClass instance, Path input, Path output) {
 *  ...
 *  }
 * </pre></blockquote>
 *
 * @see org.junit.jupiter.params.provider.Arguments
 * @see org.junit.jupiter.params.provider.ArgumentsProvider
 * @see org.junit.jupiter.params.ParameterizedTest
 * @see TestSource
 */
public class TestSourceProvider implements ArgumentsProvider, AnnotationConsumer<TestSource> {

    private Class<?> clazz;
    private Class<?>[] implementations;
    private String testFilePattern;

    @Override public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        String resourceRelPath = clazz.getName().replace('.', '/') + "/";
        Path path = Paths.get(
                requireNonNull(clazz.getClassLoader().getResource(resourceRelPath),
                        "Cannot find resource path: " + resourceRelPath).toURI()
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
                values().stream().flatMap(this::createArguments);
    }

    @Override public void accept(TestSource testSource) {
        this.clazz = testSource.value();
        this.implementations = testSource.implementations();
        this.testFilePattern = testSource.pattern();
    }

    /**
     * Creates arguments for parametrized tests as:
     * <ul>
     * <li>for each implementation new instance and resources;</li>
     * <li>if implementation is null new instance of clazz and resources.</li>
     * </ul>
     *
     * @param resources list of resources to provide for each argument's object
     * @return stream of arguments
     */
    private Stream<Arguments> createArguments(List<Path> resources) {
        List<Arguments> argsList = new ArrayList<>();
        Class<?>[] impls = implementations.length != 0 ? implementations : new Class<?>[]{clazz};
        try {
            for (Class<?> clazz : impls) {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object testedObj = constructor.newInstance();

                Object[] args = new Named<?>[resources.size() + 1];
                args[0] = named(testedObj.getClass().getSimpleName(), testedObj);
                Object[] namedResources = resources.stream()
                        .map(path -> named(path.getFileName().toString(), path))
                        .toArray();
                arraycopy(namedResources, 0, args, 1, namedResources.length);

                argsList.add(arguments((args)));
            }
            return argsList.stream();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Invalid testing class. Provide default constructor.", e);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
