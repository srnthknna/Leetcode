// https://leetcode.com/problems/2-keys-keyboard

class Solution {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            if (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}