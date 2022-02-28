// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int[] rect : rectangles) {
            int min = Math.min(rect[0], rect[1]);
            if (min > max) {
                max = min;
                count = 1;
            } else if (min == max) {
                count++;
            }
        }
        return count;
    }
}