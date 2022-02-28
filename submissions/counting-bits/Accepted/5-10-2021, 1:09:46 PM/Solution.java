// https://leetcode.com/problems/counting-bits

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) 
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}