package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasyStringIncrementerTest {
    @Test
    public void testSingleChars() {
        String test1 = "A";
        assertEquals("B", EasyStringIncrementer.incrementer(test1));
        String test2 = "C";
        assertEquals("D", EasyStringIncrementer.incrementer(test2));
        String test3 = "Z";
        assertEquals("AA", EasyStringIncrementer.incrementer(test3));
        String test4 = ",";
        assertEquals(",", EasyStringIncrementer.incrementer(test4));
    }

    @Test
    public void testMultipleChars() {
        String test1 = "AE";
        assertEquals("AF", EasyStringIncrementer.incrementer(test1));
        String test2 = "AZ";
        assertEquals("BA", EasyStringIncrementer.incrementer(test2));
        String test3 = "ZZ";
        assertEquals("AAA", EasyStringIncrementer.incrementer(test3));
        String test4 = "ZZ,B";
        assertEquals("ZZ,C", EasyStringIncrementer.incrementer(test4));
        String test5 = "ZABZ";
        assertEquals("ZACA", EasyStringIncrementer.incrementer(test5));
        String test6 = "ZYZZ";
        assertEquals("ZZAA", EasyStringIncrementer.incrementer(test6));
        String test7 = "ZZZZZ";
        assertEquals("AAAAAA", EasyStringIncrementer.incrementer(test7));
    }
}
