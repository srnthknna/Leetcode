// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max_so_far = nums[0], min_so_far = nums[0], result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp_max_so_far = Math.max(num, Math.max(max_so_far * num, min_so_far * num));
            min_so_far = Math.min(num, Math.min(max_so_far * num, min_so_far * num));
            max_so_far = temp_max_so_far;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
}