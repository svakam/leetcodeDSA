package leetcodeDSA;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers and an integer 'target', return an integer array of the indices of the input array that whose values summed equal 'target'.
public class EasyTwoSum {
    // runtime: 75 ms, faster than 11.83% submissions
    // memory: 40.1 mb, less than 5.65% submissions
    // time: O(n^2) - worst case traverse n-1 times and look at n elements
    // space: O(1) - i and j stored for n length array, constant
    int[] twoSumFirstAttempt(int[] nums, int target) {
        int i = 0;
        while (true) {
            int j = i + 1;
            // get indices of a combo being looked at
            while (j < nums.length) {
                // if it adds to target, return these indices in an array
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else {
                    j++;
                }
            }
            // if all combos looked at, return null
            if (i == nums.length - 2) {
                return null;
            }
            i++;
        }
    }

    // alt solution: two-pass HT - add items along with its index to HT, then check if the complement exists in HT, and if it does, return current index along with complement's index
    // time: O(n) - traverse n times storing nth item with index in HT, then looking up HT in O(1)
    // space: O(n) - n items stored
    int[] twoSumTwoPassHT(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("Target can't be summed with items in array");
    }

    // alt solution: one-pass HT - add items along with index to HT and in the same iteration check if complement exists
    // time: O(n) - exactly one traversal and checking if complement exists
    int[] twoSumOnePassHT(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Target can't be summed with items in array");
    }
}
