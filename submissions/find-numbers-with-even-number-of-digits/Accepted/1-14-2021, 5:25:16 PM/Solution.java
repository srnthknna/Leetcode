// https://leetcode.com/problems/find-numbers-with-even-number-of-digits

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            int calc = 0;
            while (i > 0) {
                calc++;
                i /= 10;
            }
            if (calc % 2 == 0) count++;
        }
        return count;
    }
}