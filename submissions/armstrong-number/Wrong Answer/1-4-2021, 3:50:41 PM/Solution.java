// https://leetcode.com/problems/armstrong-number

class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0, d, backUp = N;
        while (N > 0) {
            d = N % 10;
            sum += Math.pow(d, 3);
            N /= 10;
        }
        return sum == backUp;
    }
}