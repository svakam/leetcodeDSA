package leetcodeDSA;

public class EasyStringIncrementer {
    public static String incrementer(String input) {
        String incremented = null;
        StringBuilder sb = new StringBuilder();
        char lastChar = input.charAt(input.length() - 1);
        int counterAllZs = 0;
        // if input's last char is Z
        if (lastChar == 'Z') {
            // carry increment to next char
            // if next char also Z, carry increment to next char until a char isn't Z
            // if all chars are Z 
        }

        // if input's last char is not Z
        else {
            // keep whole string the same and increment last char
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if ((int) currentChar < 65 || (int) currentChar > 90) {
                    sb.append(currentChar);
                } else if (i == input.length() - 1) {
                    sb.append((char) ((int) currentChar + 1));
                } else {
                    sb.append(currentChar);
                }
            }
            incremented = sb.toString();
        }

        return incremented;
    }
}
