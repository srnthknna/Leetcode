// https://leetcode.com/problems/ugly-number

class Solution {
    public boolean isUgly(int num) {
        int nStart = 0;
        while (nStart != num) {
            nStart = num;
            if (num % 2 == 0) num /= 2;
            if (num % 3 == 0) num /= 3;
            if (num % 5 == 0) num /= 5;
        }
        return num == 1;
    }
}