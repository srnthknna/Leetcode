// https://leetcode.com/problems/sum-of-unique-elements

class Solution {
    public int sumOfUnique(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) counts[num]++;
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (counts[i] == 1)  ans += i;
        }
        return ans;
    }
}