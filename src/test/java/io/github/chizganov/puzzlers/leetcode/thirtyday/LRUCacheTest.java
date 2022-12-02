package io.github.chizganov.puzzlers.leetcode.thirtyday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {

    private static final int NOT_FOUND = -1;

    @Test
    void putAndGet_ReplaceTail() {
        LRUCache cache = new LRUCache(3);

        cache.put(2, 1);
        cache.put(3, 2);
        cache.put(4, 3);

        assertEquals(2, cache.get(3));
        assertEquals(3, cache.get(4));
        assertEquals(1, cache.get(2));

        cache.put(3, 4);

        assertEquals(1, cache.get(2));
        assertEquals(4, cache.get(3));
        assertEquals(3, cache.get(4));
    }

    @Test
    void putAndGet_ReplaceHead() {
        LRUCache cache = new LRUCache(3);

        cache.put(2, 1);
        cache.put(3, 2);
        cache.put(4, 3);

        assertEquals(3, cache.get(4));
        assertEquals(1, cache.get(2));
        assertEquals(2, cache.get(3));

        cache.put(3, 4);

        assertEquals(1, cache.get(2));
        assertEquals(4, cache.get(3));
        assertEquals(3, cache.get(4));
    }

    @Test
    void putAndGet_ReplaceMiddle() {
        LRUCache cache = new LRUCache(3);

        cache.put(2, 1);
        cache.put(3, 2);
        cache.put(4, 3);

        assertEquals(2, cache.get(3));
        assertEquals(3, cache.get(4));
        assertEquals(1, cache.get(2));

        cache.put(4, 4);

        assertEquals(1, cache.get(2));
        assertEquals(2, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void putAndGet_ReplaceLeastUsed() {
        LRUCache cache = new LRUCache(3);

        cache.put(2, 1);
        cache.put(3, 2);
        cache.put(4, 3);

        assertEquals(2, cache.get(3));
        assertEquals(3, cache.get(4));
        assertEquals(1, cache.get(2));

        cache.put(5, 4);

        assertEquals(1, cache.get(2));
        assertEquals(NOT_FOUND, cache.get(3));
        assertEquals(3, cache.get(4));
        assertEquals(4, cache.get(5));
    }

    @Test
    void putAndGet_CapacityTwo() {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1));

        cache.put(3, 3);

        assertEquals(NOT_FOUND, cache.get(2));

        cache.put(4, 4);

        assertEquals(NOT_FOUND, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void putAndGet_CapacityOne() {
        LRUCache cache = new LRUCache(1);

        cache.put(2, 1);

        assertEquals(1, cache.get(2));

        cache.put(3, 2);

        assertEquals(NOT_FOUND, cache.get(2));
        assertEquals(2, cache.get(3));
    }

}