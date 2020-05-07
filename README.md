# LeetCode Data Structures & Algorithms
Repo for all practice problems done on LeetCode. 

## Table of Contents
- Easy
  - Two Sum
- Medium
  - Add Two Numbers (LL)
  - Longest Substring Without Repeating Characters
- Hard

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
  - 

## Hard