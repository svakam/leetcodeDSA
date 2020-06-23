package leetcodeDSA;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// given a String of digits 2-9, and that each digit represents a set of letters seen on a traditional cell phone, return all combinations of letters derived from the digits
public class MediumLetterCombinations {

    // first attempt: runtime 1 ms (faster than 81.99% submissions), memory 38.2 mb, less than 98.67% submissions
    public LinkedList<String> letterCombinations(String digits) {
        LinkedList<String> combos = new LinkedList<>();
        if (digits.length() < 1) {
            return combos;
        }
        HashMap<Character, char[]> digitsLetters = new HashMap<>();
        digitsLetters.put('2', new char[]{'a', 'b', 'c'});
        digitsLetters.put('3', new char[]{'d', 'e', 'f'});
        digitsLetters.put('4', new char[]{'g', 'h', 'i'});
        digitsLetters.put('5', new char[]{'j', 'k', 'l'});
        digitsLetters.put('6', new char[]{'m', 'n', 'o'});
        digitsLetters.put('7', new char[]{'p', 'q', 'r', 's'});
        digitsLetters.put('8', new char[]{'t', 'u', 'v'});
        digitsLetters.put('9', new char[]{'w', 'x', 'y', 'z'});

        int[] counters = new int[digits.length()];
//        for (int i = 0; i < counters.length; i++) {
//            counters[i] = 0;
//        } this is redundant; assigned to 0 by default
        while (true) {
            // append letters
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                sb.append(digitsLetters.get(digits.charAt(i))[counters[i]]);
            }
            combos.add(sb.toString());

            // increment counters for each digit up to the length of the digit's character array; carry over as needed
            int i = counters.length - 1;
            if (counters[i] + 1 < digitsLetters.get(digits.charAt(digits.length() - 1)).length) {
                counters[i]++;
            } else {
                do {
                    if (counters[i] + 1 == digitsLetters.get(digits.charAt(i)).length) {
                        counters[i] = 0;
                        i--;
                    } else {
                        counters[i]++;
                        break;
                    }
                }
                while (i >= 0);
            }
            if (i < 0) {
                break;
            }
        }
        return combos;
    }

    // LC
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    LinkedList<String> output = new LinkedList<>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public LinkedList<String> solutionLC(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }
}
