package leetcodeDSA;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    // first attempt: matrix
    // time: 35 ms, faster than 13.76% Java online submissions
    // memory: 48 MB, less than 5.65% submissions
    public String convert(String s, int numRows) {
        // edge cases
        if (numRows >= s.length()) return s;
        else if (s.equals("")) return "";
        else if (numRows == 1) return s;

        // after calculating the right size, create 2D array
        int i = 0, colsToMake = 0, rowLocation = 0;
        while (i < s.length()) {
            if (rowLocation == numRows - 1) {
                while (rowLocation != 0) {
                    i++;
                    rowLocation--;
                    if (rowLocation != 0) colsToMake++;
                }
            } else if (rowLocation == 0) {
                colsToMake++;
                rowLocation++;
                i++;
            } else {
                rowLocation++;
                i++;
            }
        }
        Character[][] arr = new Character[numRows][colsToMake];

        // iterate through string and place characters in array
        i = 0;
        rowLocation = 0;
        int colLocation = 0;
        while (i < s.length()) {
            if (rowLocation == numRows - 1) {
                while (rowLocation != 0) {
                    arr[rowLocation][colLocation] = s.charAt(i);
                    i++;
                    if (i == s.length()) {
                        break;
                    }
                    rowLocation--;
                    colLocation++;
                }
            } else {
                arr[rowLocation][colLocation] = s.charAt(i);
                i++;
                rowLocation++;
            }
        }
        // iterate through array and add characters to stringbuilder
        // return that string
        StringBuilder finalString = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < colsToMake; k++) {
                if (arr[j][k] != null) {
                    finalString.append(arr[j][k]);
                }
            }
        }
        return finalString.toString();
    }

    // LC: sort by row
    public String sortByRow(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
