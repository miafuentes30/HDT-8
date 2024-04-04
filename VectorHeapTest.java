/*
 *mPuebas JUnit de la clase VectorHeap
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTest {

    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertTrue(heap.add(5));
        assertTrue(heap.add(10));
        assertTrue(heap.add(3));
        assertEquals(3, heap.size());
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(5);
        heap.add(10);
        heap.add(3);
        assertEquals(3, heap.remove().intValue());
        assertEquals(2, heap.size());
    }

    @Test
    public void testIsEmpty() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());
        heap.add(5);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testSize() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        assertEquals(0, heap.size());
        heap.add(5);
        heap.add(10);
        heap.add(3);
        assertEquals(3, heap.size());
    }
}

