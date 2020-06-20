package leetcodeDSA;

// Given a binary number, return the least number of possible operations needed to reduce the number to 0.
public class EasySubtractBinary {
    public int leastOperations(String binary) {
        int counter = 0;
        while (binary.contains("1")) {
            char lastDigit = binary.charAt(binary.length() - 1);
            if (lastDigit == '1') {
                binary = binary.substring(0, binary.length() - 2) + "0";
            } else if (lastDigit == '0') {
                binary = binary.substring(0, binary.length() - 2);
            }
            counter++;
        }
        return counter;
    }
}
