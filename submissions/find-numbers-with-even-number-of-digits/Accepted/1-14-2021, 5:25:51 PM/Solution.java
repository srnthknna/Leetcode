// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for (int i : nums) {
            int countDigits = 0;
            while (i > 0) {
                countDigits++;
                i /= 10;
            }
            if (countDigits % 2 == 0) countEven++;
        }
        return countEven;
    }
}