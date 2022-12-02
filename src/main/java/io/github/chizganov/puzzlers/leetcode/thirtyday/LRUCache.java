package io.github.chizganov.puzzlers.leetcode.thirtyday;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3309/">LRU Cache challenge</a>
 *
 * @author Ev Chizganov
 */
class LRUCache {

    final HashMap<Integer, Entry> keyToEntry;
    final int capacity;
    Entry head;
    Entry tail;

    LRUCache(int capacity) {
        keyToEntry = new HashMap<>();
        this.capacity = capacity;
    }

    int get(int key) {
        Entry e = keyToEntry.get(key);
        if (e != null && e != head) {
            if (e == tail) tail = e.next;
            removeEntryFromList(e);
            setNewHead(e);
        }

        return e != null ? e.value : -1;
    }

    void put(int key, int value) {
        if (keyToEntry.containsKey(key)) {
            Entry e = keyToEntry.remove(key);
            removeEntryFromList(e);
            if (e == tail) tail = tail.next;
            if (e == head) head = head.prev;
        }
        if (keyToEntry.size() == capacity) {
            keyToEntry.remove(tail.key);
            removeEntryFromList(tail);
            tail = tail.next;
        }

        Entry newEntry = new Entry(key, value);
        keyToEntry.put(key, newEntry);
        if (head == null || tail == null) {
            head = newEntry;
            tail = newEntry;
        } else {
            setNewHead(newEntry);
        }
    }

    private void setNewHead(Entry newHead) {
        newHead.next = null;
        newHead.prev = head;
        head.next = newHead;
        head = newHead;
    }

    private void removeEntryFromList(Entry e) {
        if (e.prev != null) e.prev.next = e.next;
        if (e.next != null) e.next.prev = e.prev;
    }

    static class Entry {

        final int key;
        final int value;
        Entry next;
        Entry prev;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

}
