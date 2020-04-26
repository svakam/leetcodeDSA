# LeetCode Data Structures & Algorithms
Repo for all practice problems done on LeetCode. 

## Easy
### Two Sum
Given an array of integers and an integer 'target', return an integer array of two integers whose sum equals 'target'. 
- First attempt: brute force
  - My instinct was to loop over the array, look at a combination of two integers and check if the sum equals 'target' only if that combination wasn't looked 
  at already. I thought this approach would be in O(n) time and O(1) space since the loop wouldn't look at elements behind i, but for much larger arrays, 
  this would approximate to O(n^2) time since we're still looking at every other element for an ith element. I thought about using a hashset at some point, 
  but for the wrong reason. 

- Approaches
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

## Hard