// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    
    private int helper(int m, int[] multipliers, int[] nums, int s) {
        if (m == multipliers.length) return 0;
        int e = nums.length - (m - s) - 1;
        int option1 = multipliers[m] * nums[s] + helper(m + 1, multipliers, nums, s + 1);
        int option2 = multipliers[m] * nums[e] + helper(m + 1, multipliers, nums, s);
        return Math.max(option1, option2);
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        return helper(0, multipliers, nums, 0);
    }
}