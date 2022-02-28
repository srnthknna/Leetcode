// https://leetcode.com/problems/smallest-range-i

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int a : nums) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        return Math.max(0, max - min - (2 * k));
    }
}