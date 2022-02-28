// https://leetcode.com/problems/check-if-it-is-a-good-array

class Solution {
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    
    public boolean isGoodArray(int[] nums) {
        int cur = nums[0];
        
        for (int i = 1; i < nums.length && cur != 1; i++)
            cur = gcd(cur, nums[i]);
        
        return cur == 1;
    }
}