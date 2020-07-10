package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasyStrCompressionTest {
    // doesn't account for lowercase vs uppercase
    @Test
    public void test() {
        EasyStrCompression e = new EasyStrCompression();
        assertNull(e.strCompression(""));
        assertEquals("a", e.strCompression("a"));
        assertEquals("abc", e.strCompression("abc"));
        assertEquals("a5", e.strCompression("aaaaa"));
        assertEquals("a5b5", e.strCompression("aaaaabbbbb"));
        assertEquals("a6b7c7", e.strCompression("aaaaaabbbbbbbccccccc"));
//        assertEquals("a10b8z1", e.strCompression("AaaAaAaaaAbBbbbbbBz"));
    }
}
