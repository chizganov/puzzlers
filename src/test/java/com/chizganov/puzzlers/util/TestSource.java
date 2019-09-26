package com.chizganov.puzzlers.util;

import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@code @TestSource} is an {@code ArgumentsSource} which provides access to
 * tested class and test resources pattern.
 *
 * @see org.junit.jupiter.params.provider.ArgumentsSource
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(TestSourceProvider.class)
public @interface TestSource {

    /**
     * Tested class, used in detection of resources used for testing.
     */
    Class<?> value();

    /**
     * Test files regex pattern. Detects which files should be used as test method argument.
     * Must contain test number.
     */
    String pattern() default "^[a-zA-Z]+\\d{2}.txt$";
}
