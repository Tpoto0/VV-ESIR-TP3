package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

class BinaryHeapTest {

    private BinaryHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        heap = new BinaryHeap<>(Comparator.<Integer>naturalOrder());
    }

    @Test
    void testPushAndPeek() {
        heap.push(10);
        heap.push(5);
        heap.push(15);
        heap.push(1);
        
        assertEquals(1, heap.peek(), "Expected minimum is 1 after insertions");
    }

    @Test
    void testPop() {
        heap.push(10);
        heap.push(5);
        heap.push(15);
        heap.push(1);

        assertEquals(1, heap.pop(), "Expected popped value is 1");
        assertEquals(5, heap.pop(), "Expected popped value is 5");
        assertEquals(10, heap.pop(), "Expected popped value is 10");
        assertEquals(15, heap.pop(), "Expected popped value is 15");
    }

    @Test
    void testEmptyHeap() {
        assertEquals(0, heap.count(), "Heap should be empty");
        assertThrows(AssertionError.class, () -> heap.pop(), "Expected AssertionError on pop with empty heap");
        assertThrows(AssertionError.class, () -> heap.peek(), "Expected AssertionError on peek with empty heap");
    }

    @Test
    void testCount() {
        assertEquals(0, heap.count(), "Expected count to be 0 for empty heap");
        
        heap.push(10);
        heap.push(20);
        assertEquals(2, heap.count(), "Expected count to be 2 after insertions");
        
        heap.pop();
        assertEquals(1, heap.count(), "Expected count to be 1 after pop");
        
        heap.pop();
        assertEquals(0, heap.count(), "Expected count to be 0 after all pops");
    }

    @Test
    void testPushInReverseOrder() {
        heap.push(3);
        heap.push(2);
        heap.push(1);

        assertEquals(1, heap.peek(), "Expected minimum is 1");
        assertEquals(1, heap.pop(), "Expected popped value is 1");
        assertEquals(2, heap.pop(), "Expected popped value is 2");
        assertEquals(3, heap.pop(), "Expected popped value is 3");
    }
}