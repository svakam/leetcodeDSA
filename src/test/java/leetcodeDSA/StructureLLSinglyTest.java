package leetcodeDSA;

import leetcodeDSA.structures.LinkedListSingly;
import leetcodeDSA.structures.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StructureLLSinglyTest {
    @Test
    public void testInstantiate() {
        LinkedListSingly ll = new LinkedListSingly();
//        assertEquals(Class.forName("LinkedListSingly"), ll.getClass());
        System.out.println(ll);
    }

    LinkedListSingly ll;

    @Before
    public void setUp() {
        ll = new LinkedListSingly();
    }

    @Test
    public void add() {
        assertEquals("Linked list is empty", ll.printValues());

        ll.addFirst(2);
        assertEquals("Node 0: 2\n", ll.printValues());

        ll.addFirst(3);
        assertEquals("Node 0: 3\nNode 1: 2\n", ll.printValues());

        ll.addLast(4);
        assertEquals("Node 0: 3\nNode 1: 2\nNode 2: 4\n", ll.printValues());

        ll.addAtIndex(5, 1);
        assertEquals("Node 0: 3\nNode 1: 5\nNode 2: 2\nNode 3: 4\n", ll.printValues());

        ll.addAtIndex(6, 16);
    }

    @Test
    public void empty() {
        assertTrue(ll.isEmpty());

        ll.addFirst(2);
        assertEquals("Node 0: 2\n", ll.printValues());

        assertFalse(ll.isEmpty());

        assertTrue(new LinkedListSingly().isEmpty());
    }

    @Test
    public void size() {
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        assertEquals(3, ll.size());
    }

    @Test
    public void peek() {
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.peekHead();
    }

    @Test
    public void remove() {
        ll.addAtIndex(10, 0);
        ll.addLast(20);
        ll.addFirst(30);
        assertEquals(30, ll.removeFirst().getValue());
        assertEquals(20, ll.removeLast().getValue());
    }
}
