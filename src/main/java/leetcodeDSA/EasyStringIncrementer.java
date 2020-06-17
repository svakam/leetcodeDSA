package leetcodeDSA;

public class EasyStringIncrementer {
    public static String incrementer(String input) {
        StringBuilder sb = new StringBuilder();
        char lastChar = input.charAt(input.length() - 1);
        // if input's last char is Z
        if (lastChar == 'Z') {
            int i = input.length() - 1;
            int carry = 1;
            // do at least once: increment from the end of string
            do {
                char currentChar = input.charAt(i);
                // if incrementing current char by existing carry leads to char greater than 90, append A and move to next char
                if ((int) currentChar + carry > 90) {
                    sb.append('A');
                    carry = 1;
                }
                // if char between A and Z, use up existing carry, increment and iterate
                else if ((int) currentChar + carry >= 65) {
                    sb.append( (char) ((int) currentChar + carry));
                    carry = 0;
                }
                // else append char normally
                else {
                    sb.append(currentChar);
                }
                i--;
            }
            while (i > -1);

            // if carry still left over, start a new letter at A
            if (carry == 1) {
                sb.append('A');
            }

            // only need to bother reversing string to correct order if input's length was greater than 1
            if (input.length() > 1) {
                // reverse the string and return
                StringBuilder sbReversed = new StringBuilder();
                i = sb.length() - 1;
                while (i > -1) {
                    sbReversed.append(sb.charAt(i));
                    i--;
                }
                return sbReversed.toString();
            } else {
                return sb.toString();
            }
        }

        // if input's last char is not Z
        else {
            // keep whole string the same and increment just last char
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
        }

        return sb.toString();
    }
}
