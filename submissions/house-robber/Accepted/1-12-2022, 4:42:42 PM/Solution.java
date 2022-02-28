// https://leetcode.com/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int t1 = 0;
        int t2 = 0;
        
        
        for (int i = 0; i < nums.length; i++) {
            int temp = t1;
            int current = nums[i];
            t1 = Math.max(t2 + current, t1);
            t2 = temp;
        }
        
        return t1;
    }
}