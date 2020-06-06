package leetcodeDSA;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

public class MediumLetterCombinations {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> digitsLetters = new HashMap<>();
        digitsLetters.put('2', new Character[]{'a', 'b', 'c'});
        digitsLetters.put('3', new Character[]{'d', 'e', 'f'});
        digitsLetters.put('4', new Character[]{'g', 'h', 'i'});
        digitsLetters.put('5', new Character[]{'j', 'k', 'l'});
        digitsLetters.put('6', new Character[]{'m', 'n', 'o'});
        digitsLetters.put('7', new Character[]{'p', 'q', 'r', 's'});
        digitsLetters.put('8', new Character[]{'t', 'u', 'v'});
        digitsLetters.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<Character[]> lettersFromInput = new LinkedList<>();
        List<String> combos = new LinkedList<>();
        for (int i = 0 ; i < digits.length(); i++) {
            lettersFromInput.add(digitsLetters.get(digits.charAt(i)));
        }
        for (int n = 0; n < lettersFromInput.size(); n++) {
            StringBuilder sb = new StringBuilder();
            for (int p = 0)
        }
        // for every digit in input, create a new loop that appends its char and adds the string to list if it's the last letter in the input
        StringBuilder sb = new StringBuilder();
        addLetter(digits, sb, lettersFromInput, combos);
    }

    // call this function for every letter
    public void addLetter(String digits, StringBuilder sb, List<Character[]> lettersFromInput, List<String> combos) {
        for (int i = 0; i < digits.length(); i++) {
            sb.append(lettersFromInput.get(setOfLetters)[variable]);
            if (i == digits.length() - 1) {
                combos.add(sb.toString());
            }
        }
        return combos;
    }
}
