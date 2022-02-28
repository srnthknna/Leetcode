// https://leetcode.com/problems/greatest-sum-divisible-by-three

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[] {0 , - 1000, - 1000};
        for (int num : nums) {
            int[] next = new int[3];
            for (int i = 0; i < 3; i++)
                next[(i + num) % 3] = Math.max(dp[(i + num) % 3], dp[i] + num);
            dp = next;
        }
        return dp[0];
    }
}