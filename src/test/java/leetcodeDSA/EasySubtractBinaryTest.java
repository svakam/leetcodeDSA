package leetcodeDSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class EasySubtractBinaryTest {
    @Test
    public void test() {
        EasySubtractBinary e = new EasySubtractBinary();
        System.out.println(e.leastOperations("111"));
        System.out.println(e.leastOperations("00111010101001"));
        System.out.println(e.leastOperations("1111111111111111111111111111111111111111111111"));
        System.out.println(e.leastOperations("10100111000000"));
    }
}
