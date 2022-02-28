// https://leetcode.com/problems/rectangle-overlap

class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        return Math.min(rect1[2], rect2[2]) > Math.max(rect1[0], rect2[0]) &&
            Math.min(rect1[3], rect2[3]) > Math.max(rect1[1], rect2[1]);
    }
}