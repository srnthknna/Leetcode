// https://leetcode.com/problems/largest-number-at-least-twice-of-others

class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int secondMax = 0;
        int ans = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
                ans = i;
            } else if (nums[i] < max && nums[i] >= secondMax) {
                secondMax = nums[i];
            }
        }
        
        if (max < secondMax * 2) {
            return -1;
        }
        
        return ans;
    }
}