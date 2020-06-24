package leetcodeDSA;

// Given an integer array that represents the heights (y-values) of bars on a graph, and each element's ith position in the array representing
// the distance from 0 on the x-axis, find the largest area possible produced by a set of 2 bars on the graph.
public class MediumContainerMostWater {
    // first attempt: brute force
    // runtime: 305 ms, faster than 21.20% solutions
    // space: 39.6 mb, less than 79.79% submissions
    public int maxArea(int[] height) {
        int largestArea = 0;

        if (height.length == 2) {
            return findArea(0, 1, height[0], height[1]);
        }

        int possibleArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            if (i < height.length - 1) {
                for (int j = i + 1; j < height.length; j++) {
                    possibleArea = findArea(i, j, height[i], height[j]);
                    if (largestArea < possibleArea) {
                        largestArea = possibleArea;
                    }
                }
            }
        }
        return largestArea;
    }
    public int findArea(int i1, int i2, int heighti1, int heighti2) {
        return ((i2 - i1) * Math.min(heighti1, heighti2));
    }

    // LC: two pointer approach
    public int maxAreaLC(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
