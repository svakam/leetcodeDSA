package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasyFindLargestPossibleValuePossibleTest {
    @Test
    public void test() {
        EasyFindLargestValuePossibleAppendFive a = new EasyFindLargestValuePossibleAppendFive();
        assertEquals(850, a.appendFive(80));
        assertEquals(5246, a.appendFive(246));
        assertEquals(6554, a.appendFive(654));
        assertEquals(9510, a.appendFive(910));
        assertEquals(-5800, a.appendFive(-800));
        assertEquals(-4556, a.appendFive(-456));
        assertEquals(-25, a.appendFive(-2));
        assertEquals(95, a.appendFive(9));
        assertEquals(529, a.appendFive(29));
        assertEquals(50, a.appendFive(0));
    }
}
