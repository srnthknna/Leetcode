// https://leetcode.com/problems/confusing-number

class Solution {
    public boolean confusingNumber(int n) {
        int[] rotate = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int rev = 0;
        int original = n;
        while (n > 0) {
            int temp = n % 10;
            rev = rev * 10 + rotate[temp];
            if (rotate[temp] < 0)
                return false;
            n = n / 10;
        }
        return rev != original;
    }
}