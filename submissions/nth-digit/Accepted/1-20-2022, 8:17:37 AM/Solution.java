// https://leetcode.com/problems/nth-digit

class Solution {
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        long count = 9;
        while (n > len * count) {
            n -= len * count;
            len += 1;
            start *= 10;
            count *= 10;
        }
        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}