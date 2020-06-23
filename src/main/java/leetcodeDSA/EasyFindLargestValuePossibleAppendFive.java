package leetcodeDSA;

import java.util.Arrays;

// Given an integer, find the largest value possible if the number 5 was added anywhere inbetween the integer
public class EasyFindLargestValuePossibleAppendFive {
    public int appendFive(int N) {
        int biggestValue = -8000;
        // remove the negative before parsing to a String and factor it back in to the permutation parsed into an int
        boolean negative = false;
        if (N < 0) {
            negative = true;
            N *= -1;
        }
        String stringN = Integer.toString(N);
        // over length of the array
        for (int i = 0; i < stringN.length() + 1; i++) {
            Character[] permutation = new Character[stringN.length() + 1];
            // put 5 at ith position
            permutation[i] = '5';
            // fill up rest of array from beginning to end with the integer's digits
            int digitInChar = 0;
            int j = 0;
            while (j < permutation.length) {
                if (permutation[j] == null) {
                    permutation[j] = stringN.charAt(digitInChar);
                    digitInChar++;
                }
                j++;
            }

            // stringify the permutation, convert to an int, and compare to biggest value so far
            StringBuilder sb = new StringBuilder();
            for (j = 0; j < permutation.length; j++) {
                sb.append(permutation[j]);
            }
            int permutationInt = Integer.parseInt(sb.toString());
            if (negative) {
                permutationInt *= -1;
            }
            if (biggestValue < permutationInt) {
                biggestValue = permutationInt;
            }

        }

        return biggestValue;
    }
}
