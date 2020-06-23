package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasySubtractBinaryTest {
    @Test
    public void test() {
        EasySubtractBinary e = new EasySubtractBinary();
        assertEquals("1 = 1", 1, e.leastOperations("1"));
        assertEquals("10 = 2", 2, e.leastOperations("10"));
        assertEquals("11 = 3", 3, e.leastOperations("11"));
        assertEquals("100 = 4", 3, e.leastOperations("100"));
        assertEquals("101 = 5", 4, e.leastOperations("101"));
        assertEquals("110 = 6", 4, e.leastOperations("110"));
        assertEquals("111 = 7", 5, e.leastOperations("111"));
        assertEquals("1000 = 8", 4, e.leastOperations("1000"));
        assertEquals("1001 = 9", 5, e.leastOperations("1001"));
        assertEquals("1010 = 10", 5, e.leastOperations("1010"));
        assertEquals("20", 6, e.leastOperations("10100"));
        assertEquals("100", 8, e.leastOperations("110100"));
    }
}
