// https://leetcode.com/problems/largest-number-at-least-twice-of-others

class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
                ans = i;
            }
        }
        if (max < secondMax * 2) {
            return -1;
        }
        return ans;
    }
}