// https://leetcode.com/problems/arithmetic-slices

class Solution {
    //Normal n2
    public int numberOfArithmeticSlices1(int[] nums) {
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
    
    public int numberOfArithmeticSlices(int[] nums) {
        int total = 0;
        int n = nums.length;
        int dp = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp = dp + 1;
                total += dp;
            } else {
                dp = 0;
            }
        }
        return total;
    }
}