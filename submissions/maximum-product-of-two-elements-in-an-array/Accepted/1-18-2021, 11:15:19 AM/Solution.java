// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1)); 
            }
        }
        return max;
    }
}