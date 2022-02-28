// https://leetcode.com/problems/armstrong-number

class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0, d, backUp = N, pow = String.valueOf(N).length();
        while (N > 0) {
            d = N % 10;
            sum += Math.pow(d, pow);
            N /= 10;
        }
        return sum == backUp;
    }
}