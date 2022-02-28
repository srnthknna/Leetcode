// https://leetcode.com/problems/get-maximum-in-generated-array

class Solution {
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            nums[i] = i % 2 == 0 ? nums[i / 2] : nums[i / 2] + nums[(i / 2) + 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}