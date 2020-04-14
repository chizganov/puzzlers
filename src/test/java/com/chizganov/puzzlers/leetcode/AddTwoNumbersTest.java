package com.chizganov.puzzlers.leetcode;

import com.chizganov.puzzlers.util.TestSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTwoNumbersTest {

    @ParameterizedTest
    @TestSource(AddTwoNumbers.class)
    void addTwoNumbers(AddTwoNumbers solution, Path input, Path output) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(input);
             BufferedReader out = Files.newBufferedReader(output)) {
            AddTwoNumbers.ListNode l1 = Arrays.stream(in.readLine().split(" "))
                    .map(Integer::parseInt).collect(ListNodeCollector.INSTANCE);
            AddTwoNumbers.ListNode l2 = Arrays.stream(in.readLine().split(" "))
                    .map(Integer::parseInt).collect(ListNodeCollector.INSTANCE);

            AddTwoNumbers.ListNode expectedResult = Arrays.stream(out.readLine().split(" "))
                    .map(Integer::parseInt).collect(ListNodeCollector.INSTANCE);
            AddTwoNumbers.ListNode actualResult = solution.addTwoNumbers(l1, l2);

            assertEquals(expectedResult, actualResult);
        }
    }

    static class ListNodeCollector implements Collector<Integer, LinkedList<Integer>, AddTwoNumbers.ListNode> {

        public static final ListNodeCollector INSTANCE = new ListNodeCollector();

        private ListNodeCollector() {
        }

        @Override public Supplier<LinkedList<Integer>> supplier() {
            return LinkedList::new;
        }

        @Override public BiConsumer<LinkedList<Integer>, Integer> accumulator() {
            return LinkedList::add;
        }

        @Override public BinaryOperator<LinkedList<Integer>> combiner() {
            return (l1, l2) -> {
                l1.addAll(l2);
                return l1;
            };
        }

        @Override public Function<LinkedList<Integer>, AddTwoNumbers.ListNode> finisher() {
            return (list) -> {
                AddTwoNumbers.ListNode root = new AddTwoNumbers.ListNode(0);
                AddTwoNumbers.ListNode current = root;
                for (int n : list) {
                    current.next = new AddTwoNumbers.ListNode(n);
                    current = current.next;
                }

                return root.next;
            };
        }

        @Override public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }

}