// https://leetcode.com/problems/greatest-sum-divisible-by-three

class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums)
            for (int i : Arrays.copyOf(dp, dp.length))
                dp[(i + num) % 3] = Math.max(dp[(i + num) % 3], i + num);
        return dp[0];
    }
}