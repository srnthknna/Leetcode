// https://leetcode.com/problems/jump-game-ii

class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int steps = 0, cur = 0, far = 0;
        
        while (cur < nums.length) {
            int newfar = far;
            while (cur <= far) {
                newfar = Math.max(cur + nums[cur], newfar);
                cur++;
            } 
            steps++;
            far = newfar;
            if (far >= nums.length - 1) break;
        }
        return steps;
    }
}