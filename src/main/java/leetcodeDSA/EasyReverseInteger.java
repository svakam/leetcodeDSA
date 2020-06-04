package leetcodeDSA;

import java.util.LinkedList;

public class EasyReverseInteger {
    // first attempt: push and pop with modulo
    public int reverse(int x) {
        if (x > -9 && x < 9) { return x; }
        int reversedInt = 0;
        LinkedList<Integer> reversedLL = new LinkedList<>();
        while (x != 0) {
            reversedLL.add(x % 10);
            x = x / 10;
        }
        for (int i = 0, n = reversedLL.size(); i < n; i++) {
            if (i == 0 && reversedLL.get(0) == 0) { continue; }
            reversedInt = reversedInt + reversedLL.get(i) * (int) Math.pow(10, ((n - 1) - i));
        }
        if (x < 0) { reversedInt = reversedInt * -1; }
        return reversedInt;
    }

    // LC: push and pop, check for overflow
    public int LCreverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
