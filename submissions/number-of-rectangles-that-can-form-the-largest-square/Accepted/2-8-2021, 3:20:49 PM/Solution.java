// https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int count = 0;
        for (int[] rect : rectangles) {
            min = Math.min(rect[0], rect[1]);
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