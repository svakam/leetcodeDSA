package leetcodeDSA;

// Given a string, implement method to perform basic string compression using counts of repeating characters
public class EasyStrCompression {
    public String strCompression(String s) {
        if (s.length() == 0) return null;
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1) return sb.append(s).append(1).toString();

        int strIndex = 0;
        int repeatCount = 0;
        int strLen = s.length();
        char repeatedChar = s.charAt(0);

        while (strIndex < strLen - 1) {
            if (s.charAt(strIndex) == repeatedChar) {
                repeatCount++;
            } else {
                sb.append(repeatedChar).append(repeatCount);
                repeatedChar = s.charAt(strIndex);
                repeatCount = 0;
            }
            strIndex++;
        }

        if (sb.toString().length() >= strLen) return s;

        return sb.toString();
    }
}
