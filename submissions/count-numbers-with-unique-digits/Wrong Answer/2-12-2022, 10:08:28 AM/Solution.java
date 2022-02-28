// https://leetcode.com/problems/count-numbers-with-unique-digits

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 10, uniqueDigit = 9, availableDigit = 9;
        while (n-- > 1) {
            uniqueDigit *= availableDigit;
            res += uniqueDigit;
            availableDigit--;
        }
        return res;
    }
}