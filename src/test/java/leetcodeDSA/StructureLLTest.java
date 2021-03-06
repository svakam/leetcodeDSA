package leetcodeDSA;

import leetcodeDSA.structures.LinkedListDoubly;
import leetcodeDSA.structures.LinkedListSingly;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StructureLLTest {
    @Test
    public void testInstantiate() {
        LinkedListSingly ll = new LinkedListSingly();
        System.out.println(ll);
        LinkedListDoubly lld = new LinkedListDoubly();
        System.out.println(lld);
    }

    LinkedListSingly ll;
    LinkedListDoubly lld;

    @Before
    public void setUp() {
        ll = new LinkedListSingly();
        lld = new LinkedListDoubly();
    }

    @Test
    public void add() {
//        assertEquals(e.expect(NullPointerException.class), ll.printValues());
//        assertThrows("Linked list is empty", ll.printValues());
//        assertThrows("Linked list is empty", lld.printValues());

        ll.addFirst(2);
        assertEquals("2 ", ll.printValues());
        lld.addFirst(2);
        assertEquals("2 ", lld.printValues());

        ll.addFirst(3);
        assertEquals("3 2 ", ll.printValues());
        lld.addFirst(3);
        assertEquals("3 2 ", lld.printValues());

        ll.addLast(4);
        assertEquals("3 2 4 ", ll.printValues());
        lld.addLast(4);
        assertEquals("3 2 4 ", lld.printValues());

        ll.addAtIndex(5, 1);
        assertEquals("3 5 2 4 ", ll.printValues());
        lld.addAtIndex(5, 1);
        assertEquals("3 5 2 4 ", lld.printValues());

        // need test for exception
//        ll.addAtIndex(6, 16);
//        lld.addAtIndex(6, 16);
    }

    @Test
    public void empty() {
        assertTrue(ll.isEmpty());
        assertTrue(lld.isEmpty());

        ll.addFirst(2);
        assertEquals("2 ", ll.printValues());
        lld.addFirst(2);
        assertEquals("2 ", lld.printValues());

        assertFalse(ll.isEmpty());
        assertFalse(lld.isEmpty());

        assertTrue(new LinkedListSingly().isEmpty());
        assertTrue(new LinkedListDoubly().isEmpty());
    }

    @Test
    public void size() {
        ll.addLast(2);
        assertEquals(1, ll.size());
        ll.addLast(3);
        assertEquals(2, ll.size());
        ll.addLast(4);
        assertEquals(3, ll.size());
        lld.addLast(2);
        assertEquals(1, lld.size());
        lld.addLast(3);
        assertEquals(2, lld.size());
        lld.addLast(4);
        assertEquals(3, lld.size());
        lld.addLast(5);
        assertEquals(4, lld.size());
    }

    @Test
    public void peek() {
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        assertEquals(5, ll.peekHead().getValue());
        assertEquals(7, ll.peekTail().getValue());
        assertEquals(5, ll.peekAtIndex(0).getValue());
        assertEquals(6, ll.peekAtIndex(1).getValue());
        assertEquals(7, ll.peekAtIndex(2).getValue());
        lld.addLast(5);
        lld.addLast(6);
        lld.addLast(7);
        assertEquals(5, lld.peekHead().getValue());
        assertEquals(7, lld.peekTail().getValue());
        assertEquals(5, lld.peekAtIndex(0).getValue());
        assertEquals(6, lld.peekAtIndex(1).getValue());
        assertEquals(7, lld.peekAtIndex(2).getValue());
        lld.addLast(9);
        assertEquals(9, lld.peekAtIndex(3).getValue());
        lld.addFirst(10);
        assertEquals(10, lld.peekAtIndex(0).getValue());
    }

    @Test
    public void remove() {
        ll.addAtIndex(10, 0);
        ll.addLast(20);
        ll.addFirst(30);
        assertEquals("30 10 20 ", ll.printValues());
        assertEquals(30, ll.removeFirst().getValue());
        assertEquals(20, ll.removeLast().getValue());
        assertEquals(10, ll.removeAtIndex(0).getValue());
        lld.addAtIndex(10, 0);
        lld.addLast(20);
        lld.addFirst(30);
        assertEquals("30 10 20 ", lld.printValues());
        assertEquals(30, lld.removeFirst().getValue());
        assertEquals(10, lld.removeAtIndex(1).getValue());
        assertEquals(20, lld.removeLast().getValue());
    }
}
