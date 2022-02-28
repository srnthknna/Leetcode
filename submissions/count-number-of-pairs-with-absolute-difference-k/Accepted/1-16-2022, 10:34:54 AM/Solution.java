// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k

class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] arr = new int[201];
        for (int num : nums) {
            arr[num]++;
        }
        int ans = 0;
        for (int i = k + 1; i < 201; i++)
            ans += arr[i] * arr[i - k];
        return ans;
    }
}