package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasyStrCompressionTest {
    @Test
    public void test() {
        EasyStrCompression e = new EasyStrCompression();
        assertEquals("abc", e.strCompression("abc"));
        assertEquals("a6b7c7", e.strCompression("aaaaaabbbbbbbccccccc"));
    }
}
