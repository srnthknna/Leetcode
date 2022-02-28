// https://leetcode.com/problems/maximum-product-difference-between-two-pairs

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return (nums[length - 1] * nums[length - 2]) - (nums[0] * nums[1]);
    }
}