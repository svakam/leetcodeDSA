package leetcodeDSA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Given a string, find the length of the longest substring without repeating characters.
public class LengthLongestSubStr {
    // first attempt: parse and backtrack (sliding window)
    // runtime: 101ms (faster than 11.48% submissions)
    // memory: 39.7 MB (less than 12.75% submissions)
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        int i = 0;
        int lengthOfLongestSS = 0;
        while (i < s.length()) {
            HashSet<Character> charsSeenForASubStr = new HashSet<>();
            int lengthOfSubStr = 0;
            char repeatedChar;
            while (!charsSeenForASubStr.contains(s.charAt(i))) {
                charsSeenForASubStr.add(s.charAt(i));
                lengthOfSubStr++;
                i++;
                if (i == s.length()) break;
            }
            if (lengthOfSubStr > lengthOfLongestSS) lengthOfLongestSS = lengthOfSubStr;
            if (i != s.length()) {
                repeatedChar = s.charAt(i);
                i--;
                while (s.charAt(i) != repeatedChar) i--;
                i++;
            }
        }
        return lengthOfLongestSS;
    }

    // brute force
    public int bruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    // sliding window
    public int LCSlidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // sliding window optimized (hashmap)
    public int LCSlidingWindowHM(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
