// https://leetcode.com/problems/largest-number-at-least-twice-of-others

class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) { 
                max = nums[i];
                ans = i;
            }
        }
        for (int num : nums) {
            if (max != num && max < num * 2) {
                return -1;
            }
        }
        return ans;
    }
}