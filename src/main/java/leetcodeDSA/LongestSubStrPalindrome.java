package leetcodeDSA;

import java.util.HashMap;
import java.util.LinkedList;

public class LongestSubStrPalindrome {
    // first attempt: time limit exceeded (runtime: 634 ms)
    public boolean isPalindromeFirstAttempt(String s, int start, int end) {
        while (start != end) {
            if (s.charAt(start) == s.charAt(end) && (end - start > 0)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        return start == end || start > end;
    }
    public String longestPalindrome(String s) {
        HashMap<Character, Integer> charsSeenWithInitPos = new HashMap<>();
        HashMap<Character, LinkedList<Integer>> repeatedChars = new HashMap<>();
        LinkedList<Character> repeatedCharsList = new LinkedList<>();
        int[] longestPalinLocations = new int[]{0,0};
        int longestPalinLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!charsSeenWithInitPos.containsKey((Character) s.charAt(i))) {
                charsSeenWithInitPos.put((Character) s.charAt(i), i);
            } else {
                if (repeatedChars.containsKey((Character) s.charAt(i))) {
                    LinkedList<Integer> locationsSeen = repeatedChars.get((Character) s.charAt(i));
                    locationsSeen.add(i);
                    repeatedChars.put((Character) s.charAt(i), locationsSeen);
                } else {
                    repeatedCharsList.add((Character) s.charAt(i));
                    LinkedList<Integer> locationsSeen = new LinkedList<>();
                    locationsSeen.add(charsSeenWithInitPos.get((Character) s.charAt(i)));
                    locationsSeen.add(i);
                    repeatedChars.put((Character) s.charAt(i), locationsSeen);
                }
            }
        }
        for (Character repeatedChar : repeatedCharsList) {
            LinkedList<Integer> locationsOfRepeatedChar = repeatedChars.get(repeatedChar);
            for (int j = 0; j < locationsOfRepeatedChar.size(); j++) {
                for (int k = locationsOfRepeatedChar.size() - 1; k > 0; k--) {
                    int start = locationsOfRepeatedChar.get(j);
                    int end = locationsOfRepeatedChar.get(k);
                    if ((end - start) > longestPalinLen && (end - start) > 0) {
                        if (isPalindromeFirstAttempt(s, start, end)) {
                            longestPalinLocations[0] = start;
                            longestPalinLocations[1] = end;
                            longestPalinLen = end - start;
                        }
                    }
                }
            }
        }
        if (s.length() > 0) {
            return s.substring(longestPalinLocations[0], longestPalinLocations[1] + 1);
        } else {
            return s;
        }
    }
}
