// https://leetcode.com/problems/add-digits

class Solution {
    public int addDigits(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
            if (num == 0 && digitSum > 9) {
                num = digitSum;
                digitSum = 0;
            }
            
        }
        return digitSum;

    }
}