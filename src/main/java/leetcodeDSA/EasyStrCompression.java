package leetcodeDSA;

// Given a string, implement method to perform basic string compression using counts of repeating characters
public class EasyStrCompression {
    public String strCompression(String s) {
        if (s.length() == 0) return null;
        if (s.length() == 1) return s;
        StringBuilder sb = new StringBuilder();

        int strIndex = 0;
        int repeatCount = 0;
        int strLen = s.length();
        char repeatedChar = s.charAt(0);
        boolean completedAppend = false;

        while (strIndex < strLen) {
            char currentChar = s.charAt(strIndex);
            if (currentChar == repeatedChar) {
                repeatCount++;
                completedAppend = false;
            } else {
                sb.append(repeatedChar).append(repeatCount);
                repeatCount = 1;
                repeatedChar = s.charAt(strIndex);
                completedAppend = true;
            }
            strIndex++;
        }

        if (!completedAppend) {
            sb.append(repeatedChar).append(repeatCount);
        }

        if (sb.toString().length() >= strLen) return s;

        return sb.toString();
    }
}
