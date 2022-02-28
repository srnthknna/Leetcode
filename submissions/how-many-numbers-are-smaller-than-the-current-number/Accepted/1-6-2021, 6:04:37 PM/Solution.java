// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ans = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[j] < nums[i])
                    ans++;
            }
            res[i] = ans;
        }
        return res;
    }
}