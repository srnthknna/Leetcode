// https://leetcode.com/problems/single-number

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= num[i];
        }
        return a;
    }
}