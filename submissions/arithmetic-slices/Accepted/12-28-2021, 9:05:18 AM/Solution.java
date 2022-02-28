// https://leetcode.com/problems/arithmetic-slices

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[ j - 1] == diff) total++;
                else break;
            }
        }
        return total;
    }
}