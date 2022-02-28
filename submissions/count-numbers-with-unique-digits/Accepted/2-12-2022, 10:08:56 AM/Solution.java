// https://leetcode.com/problems/count-numbers-with-unique-digits

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/83041/JAVA-DP-O(1)-solution.
        if (n == 0) return 1;
        int res = 10, uniqueDigit = 9, availableDigit = 9;
        while (n-- > 1) {
            uniqueDigit *= availableDigit;
            res += uniqueDigit;
            availableDigit--;
        }
        return res;
    }
}