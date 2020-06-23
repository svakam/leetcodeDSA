# LeetCode Data Structures & Algorithms
Repo for all practice problems done on LeetCode and more. 

## Table of Contents
- [Easy](#easy)
  - [Two Sum](#two-sum)
  - [Reverse Integer](#reverse-integer)
  - [String Incrementer (non-LC)](#string-incrementer-non-lc)
  - [Subtract Binary (non-LC)](#subtract-binary-non-lc)
- [Medium](#medium)
  - [Add Two Numbers: LL](#add-two-numbers-ll)
  - [Longest Substring Without Repeating Characters](#longest-substring-without-repeating-characters)
  - [Longest Palindromic Substring](#longest-palindromic-substring)
  - [Zigzag Conversion](#zigzag-conversion)
  - [Letter Combinations of a Phone Number](#letter-combinations-of-a-phone-number)
  - [Find Largest Possible Value When Inserting '5' (non-LC)](#find-largest-value-possible-given-a-digit-to-append-non-lc)
- [Hard](#hard)

## Easy
### Two Sum
Given an array of integers and an integer 'target', return an integer array of two integers whose sum equals 'target'. 
- First attempt: brute force
  - My instinct was to loop over the array, look at a combination of two integers and check if the sum equals 'target' only if that combination wasn't looked 
  at already. I thought this approach would be in O(n) time and O(1) space since the loop wouldn't look at elements behind i, but for much larger arrays, 
  this would approximate to O(n^2)*1/2 ~ O(n^2) time since we're still looking at every other element for an ith element. I thought about using a hashset at some point, 
  but for the wrong reason. 

- Approaches: time and efficiency
  - Brute force
    - Time: O(n^2)
    - Space: O(1)
  - Two-pass HT
    - Time: O(n)
    - Space: O(n)
    - Explanation: This approach first traverses n elements in an array to store the nth value along with its index in a hashmap. Another traversal is done
    to check if the complement (target - array[i]) exists as a key in the hashtable. If it does, return the index along with the complement's index. This lookup time
    is O(1) for the second traversal, so O(n) time total. 
  - One-pass HT
    - Time: O(n)
    - Space: O(n)
    - Explanation: This approach utilizes a one-pass traversal to first check if the complement exists, and if it does, return its index and the current index. 
    If it doesn't, only then add the current element and its index to the HT. 
    
### Reverse Integer
Reverse a given integer. If the integer overflows, return 0. 
- First attempt: push and pop with modulo
  - To reverse an integer, get the digit at the 1's place and add it to a LinkedList<Integer> that stores the reversed integers. Reassign the input integer to the integer
  after the last digit has been removed and added to the list. Once the input integer can't be divided any further (input / 10 = 0), iterate through the list and create the
  reversed integer by multiplying the appropriate digits by 10 to the power of the place that it needs to be in. 
  - I wasn't familiar with how Java deals with integer overflow, what the max value is for an int, and how to deal with overflow in this case. I'm assuming that for this 
  reason, the ratio of upvotes/downvotes in LC for this question is unfavorable since it favors those who happen to know the Java library (more specifically, how Integer.MAX_VALUE works)
  over traditional whiteboarding applicants. 
- Approaches: time and efficiency
  - Push and pop with modulo
    - Time: O(n). Iterate through every digit once to pop and push into the list, and iterate again through the list to create a final reversed integer (O(2n) ~ O(n)). 
    - Space: O(n). The LinkedList<Integer> to hold the digits will contain every digit in the input integer. 
  - LC: push and pop digits and check before overflow
    - Time: O(log(x)). There are roughly log(input) digits in the input integer. Example: x = 100, log(100) = 2, roughly 2 digits. 
    - Space: O(1). 
    - Explanation: build the reverse integer one digit at a time. While doing so, check beforehand whether or not appending another digit causes overflow. This is similar
    to my approach, but takes into account overflow. A pop operation is `pop = x % 10; x /= 10`, and a push operation is `temp = rev * 10 + pop; rev = temp;`. 
    `temp = rev * 10 + pop` has the potential to cause overflow if the result is greater than `Integer.MAX_VALUE`. Therefore, a check is needed before `rev` is assigned
    to `temp`. Knowing that `Integer.MAX_VALUE` is 2147483647, if `pop` is ever greater than 7, there is a potential to overflow if `rev == Integer.MAX_VALUE / 10`. Overflow will 
    also occur if `rev > Integer.MAX_VALUE`. 
    
### String Incrementer (non-LC)
Given a String, increment it by 1. Example: "AB" -> "AC", "AZ" -> "BA", "ZABA" -> "ZABB", "ZZYZ" -> "ZZZA", "ZZZZ" -> "AAAAA"

- My solution: carry vs. non carry
  - Treat the String like a number, but in base 26. Since the function only increments the String by 1, there are only 2 cases possible: the last digit
  is either Z or not Z. If the last is Z, this is like the last digit of a number being 9 and adding 1 to it. The sum is 10, and a 0 is used while 
  the 1 needs to be carried. Similarly, A is the new digit while the increment is carried to the next placeholder. If the next sum is also greater than 
  Z, continue to carry the increment until the increment is fully used or the String needs to start over with all A's. 
- Time and efficiency
  - Time: O(2n) ~ O(n). Worst case, the String looks like "ZZZZZ" and the increment needs to be carried over every letter to finally output "AAAAAA".
  In addition, since the function's middleman output is the reversed String (since it starts with the "1's" place and builds up), an additional reversal
  is implemented for the final output, causing O(2n) ~ O(n).  
  - Space: O(n). The original String is immutable, thus an additional String copy is created for the output per n letters in the input. 

### Subtract Binary (non-LC)
Given a binary number in String format, return the fewest number of operations it takes to reduce it to 0.

- My solution: string parsing
  - If the number ends in 1, it can be subtracted by 1. Take the substring from the beginning up to the end excluding the last digit. 
  Append a 0. If the number ends in 0, it can be divided by 2. Take the substring from the beginning up to the end excluding the last digit. 
  Do a check at the beginning for leading 0s and remove them from the binary. 
- Time and efficiency
  - Time: O(n). If the string still contains a "1", the while block will execute. [String.contains() time complexity](https://stackoverflow.com/questions/4089558/what-is-the-big-o-of-string-contains-in-java) 
  varies on how it's implemented, and O(n) is an upper bound, which is orthogonal to best/average/worst case. 
  - Space: O(1). 
  
### Find Largest Value Possible Given a Digit to Append (non-LC)
Given an integer from -8000 to 8000, find the largest value possible by appending the digit "5" anywhere in the integer. 

Example: 234 -> 5234, 625 -> 6525, 987 -> 9875, -995 -> -5995

- First attempt: parse input to char[], add 5, parse back to int and compare
  - Parse the input into a String format. Create a char array of the number of digits in the input + 1, which makes room for the 5. Place 5 in every possible element while filling 
  in the remaining with the input's digits in order. Parse the results back into an int and set it to the biggest value if it's the biggest one seen thus far. 
  
- Approach: time and efficiency
  - Time: O(n^2) and O(n). One loop is conducted over the length of the integer for every possible element that 5 was placed in. 2 more inner loops start within, to loop over the 
  length of the array to fill it with the input's digits, and over the array to parse it back into an int. Since the input will only be 4 digits long at most, O(n^2) should be 
  insignificant enough to approximate to O(n). If the digits were unlimited, runtime would quickly get worse at around O(2n^2) or O(3n^2) ~ O(n^2). 
  - Space: O(n). The char array is as long as the number of digits in the int, which can get at most 4 digits long, so O(4n) ~ O(n). Additionally, the char array is actually an array
   of Character's, which are wrapper objects that take up more memory than their primitive counterparts. 

## Medium
### Add Two Numbers (LL)
Given two LLs representing the digits of two reversed non-negative integers, add the integers together and return as a LL. The final LL can be reversed. 
- First attempt: full modulo and exponents
  - For every new place, I added the sum of the digits multiplied to the power of 10 and obtained a final total sum. Then I modulo'd the sum by 10
  to get the last place and add that to the final reversed sum LL. The sum would then be reassigned to the sum without the last place, which is obtained by dividing 
  it by 10. This process would loop until the sum modulo'd by 10 equals itself. 
  - The issue with this approach doesn't include the edge cases where either added number goes beyond the limits of the sizes of primitives and its object wrappers. 
  In fact, the solution passed all 1563 tests on LC except for the last 2 or 3, whose numbers were 100000000000000000000001 and 9 - the former of which is too large
  to be stored in even a double. Number literals can be remedied from this issue by adding an L at the end of a long or a D for a double, but this won't work for 
  variables. I think this solution would've been quite elegant, but the edge case prevented it from passing on LC.

- Approaches: time and efficiency
  - Full modulo and exponents
    - Time: O(n)
    - Space: O(n)
    - Explanation: traversing n nodes of both numbers and then n digits of the final sum should be O(3n) ~ O(n) time. A node is created for each final digit in the 
    sum, O(n) space. 
  - Elementary math
    - Time: O(max(m,n))
    - Space: O(max(m,n))
    - Runtime: 1 ms
    - Memory: 39.3 MB
    - Explanation: This approach uses runners on each list, checks if either one is null, then adds both values together and creates a new node out of the sum 
    for the final LL. It takes into account carried values (9 + 2 = 11), where if the sum of two digits is larger than 9, the 1 carries over to the next sum of digits. 
    The edge cases are accounted for as well: one list longer than the other, one list is null, and the sum having an extra carry of one at the very end (999 + 1). 
    Time and space complexity are written as such since the max iterations for time would be over the longest list, and the max number of nodes are created for the 
    longest list as well (O(max(m,n) + O(1) carry) ~ O(max(m,n))).
    
### Longest Substring Without Repeating Characters
Given a string, return the length of the longest substring that doesn't contain a repeating character. 
- First attempt: parsing string and backtracking to last unique char
  - For Java, charAt(index i) is the only way to go about parsing a string. While i doesn't exceed the length of the string, parse through the string, keeping track
  of the length of a given substring of unique characters seen thus far. Unique characters are kept track of with a hashset that stores characters seen for a given
  substring. If a character being looked at is in the hashset, get the length of this substring, store it as the longest substring if it's longer than the previous
  length, and trace back to the character that proceeds the character that was repeated. Reset the hashset and the length of the substring and repeat this process. 

- Approaches: time and efficiency
  - My solution: parsing and backtracking (sliding window)
    - Time: O(n)
    - Space: O(n)
    - Explanation: Worst case, with a given string like "abcabcabcabcabcabcabc", this implementation would cause each letter to be looked at 4 times due to the backtracing. 
    For n characters, this is a time of O((m+1)*n) ~ O(mn), where m is the number of unique characters in each repeated longest substring. For space, assuming no repeated
    characters, the substring would be as long as n length of the whole string, O(n). 
  - Brute force
    - Time: O(n^3) 
    - Space: O(min(n,m))
    - Explanation: I can't understand this method at the moment. Will update later. Code is in the class for this problem. 
    - https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/

### Longest Palindromic Substring
Given a String s, return the longest substring that is also a palindrome. 
- First attempt: I created lists via hashmaps of the locations of repeated characters, and then checked each set of repeated characters for a longest palindrome. If the current set 
is longer than the current length of the longest palindrome, check if it's a valid palindrome and reset that length and the current palindrome. This approach was not accepted by LC 
(runtime > 600ms exceeded time limit). 

- Approaches: time and efficiency
  - My solution: track indices of repeated chars
    - Time: O(n). One iteration of the string is done to get all repeated char locations. Then for every repeated character, check where it's repeated and iterate through the substring
    to check for a palindrome. This can approach O(n^2) if the entire string is a palindrome. 
    - Space: O(1). Number of repeated characters are independent of the size of the input string. If every character in the string is unique, this can approach O(n) since each character
    is stored in the hashmaps along with where it's located. 
  - LC: expand around center
    - Time: O(n^2)
    - Space: O(1)
    - Explanation: A palindrome can be expanded from its center, and there are 2n - 1 such centers. This takes into account the fact that a palindrome can originate between two letters
    ("abba"). A palindrome is checked for at every location of the string, and this can approach O(n^2) if the entire string is a palindrome. 

### ZigZag Conversion
Given a String s and an integer of number of rows, return the string after it's been 'zigzagged'. 
- Example: "ABCABCDEFDEF", rows = 3
```
A . B . F
B A C E D F -> "ABFBACEDFCDE"
C . D . E
```
- First attempt: creating a matrix that holds the zigzagged string and looping through it
  - I first determined the size of the matrix that needs to hold the zigzagged string. I parsed through the input string, and given a character of the string currently being looked 
  at, I would determine what row it's placed at. If the rows have been filled up for 1 column, I change the row and column position accordingly, effectively zigzagging 
  the string until the row is reset to 0. Once the size is determined, I created the array and looped through the string again to fill the array with the characters. I finally
  loop through the array's rows to output the final string. 
  
- Approaches: time and efficiency
  - My solution: creating and looping through matrix
    - Time: O(n^3). I loop through n characters of the string to find the matrix size, loop again through n characters to place the characters into the matrix, and loop through
    the array's size to get the output string. This can get higher than O(n^3) if there are a lot of empty spaces within the array, assuming a large number of rows for large strings.
    This is not a great approach. 
    - Space: O(n). As the number of rows increases and the string gets longer, there is more potential for 'empty' spaces in the array with characters being placed within the zigzag. 
    For every new row allotted above 2, there is an additional column created for each character zigzagging back to the top of the matrix. So for a String of n characters, m rows, 
    and k columns, the matrix size will be m * k(1 + m - 2) = m * k(m - 1) = m * km - k = m^2*k - k = k(m^2) - k. For m rows, there is the potential for 1 column to be fully filled 
    up to m, and then (m - 2) columns after that. Example: "PAYPALISHIRING", 5 rows -> PAYPA takes up 1 column, then 3 columns, 1 each for LIS on the way back up = 4 columns for 5 rows
    per 5 + 3 = 8 characters. All in all, wasteful. 
  - LC: Sort by row
    - Time: O(n)
    - Space: O(n)
    - Explanation: Use Math.min(numRows, s.length()) to represent non-empty rows of the zigzag. Iterate through s from left to right, appending each character to appropriate row. The 
    row is tracked with current row and current direction variables. The current direction changes only when we moved up to the topmost row or down to the bottommost. 
  
### Letter Combinations of a Phone Number
Given a String of digits 2-9, and that each digit represents a set of letters seen on a traditional phone keypad, return all possible combinations of letters when associating each digit's 
letters with another's. 

Example: "23" -> "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"

- First attempt: tracking each digit's current letter to append to a combination
  - If 2 is associated with the character array "abc", 3 is associated with "def", and so on, appending characters to make sure each combination is unique requires functionality to 
  keep track of which letter is being looked at for each digit. This is similar to incrementing a number and carrying over values when the max value of a unit is reached (i.e. carrying
  the 1 over to the tens digit when 9 + 1 is executed, since 9 is the max value in the decimal system, 9 is reset to 0, and the 1 is carried). For example, in "23", when all letters 
  of 3 are combined with 2 ("ad", "ae", "af"), 3 must be reset from "f" to "d" again to start combining with "b" to get "bd", "be", "bf". 

- Approaches: time and efficiency
  - My solution: tracking digit letters
    - Time: O(3^n * 4^m), where n is the number of digits in the input that maps to 3 letters and m is the number of digits that map to 4 letters, and n + m is the total number of 
    digits in the input. 
    - Space: O(3^n * 4^m). The list of combinations will be 3^n * 4^m combinations long. 
  - LC: backtracking
    - Time: same as above
    - Space: same as above
    - Explanation: [Backtracking](https://en.wikipedia.org/wiki/Backtracking) is a general algorithm for finding solutions by exploring all possible candidates. If the candidate 
    isn't a solution, the algorithm discards it by making some changes on the previous step (backtracking) and then trying again. The backtrack 
    function `backtrack(combination, next_digits)` takes as arguments an ongoing combination and the next digits to check. If there are no more digits to check, the current 
    combination is done. If there are more digits, iterate over the mapped letters, append to the combination, and proceed to the next digit. This solution is recursive. 

## Hard
