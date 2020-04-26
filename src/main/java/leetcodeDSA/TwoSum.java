package leetcodeDSA;

// Given an array of integers and an integer 'target', return an integer array of the indices of the input array that whose values summed equal 'target'.
public class TwoSum {
    int[] twoSum(int[] nums, int target) {
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
}
