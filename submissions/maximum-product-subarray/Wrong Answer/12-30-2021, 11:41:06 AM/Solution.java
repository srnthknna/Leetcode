// https://leetcode.com/problems/maximum-product-subarray

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max_so_far = 1, min_so_far = 1, result = 0;
        
        for (int num : nums) {
            int temp_max_so_far = Math.max(num, Math.max(max_so_far * num, min_so_far * num));
            min_so_far = Math.min(num, Math.min(max_so_far * num, min_so_far * num));
            max_so_far = temp_max_so_far;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
}