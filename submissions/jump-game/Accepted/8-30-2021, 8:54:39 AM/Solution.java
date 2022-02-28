// https://leetcode.com/problems/jump-game

class Solution {
    public boolean canJump(int[] nums) {
        int far = 0, cur = 0;
        while(cur <= far) {
            far = Math.max(far, cur + nums[cur]);
            if (far >= nums.length - 1) return true;
            cur++;
        }
        return false;
    }
}