// https://leetcode.com/problems/sum-of-all-subset-xor-totals

class Solution {
    public int subsetXORSum(int[] nums) {
        return sumXor(nums, 0, 0);
    }
    
    private int sumXor(int[] nums, int start, int soFar) {
        if (start == nums.length) return soFar;
        return sumXor(nums, start + 1, soFar) + sumXor(nums, start + 1, soFar ^ nums[start]);
    }
}