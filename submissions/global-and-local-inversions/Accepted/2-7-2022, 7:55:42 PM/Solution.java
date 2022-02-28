// https://leetcode.com/problems/global-and-local-inversions

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            max = Math.max(nums[i], max);
            if (max > nums[i + 2]) return false;
        }
        return true;
    }
}