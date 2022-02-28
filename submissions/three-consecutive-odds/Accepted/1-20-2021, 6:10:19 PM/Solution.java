// https://leetcode.com/problems/three-consecutive-odds

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int countOdd = 0;
        for (int i : arr) {
            if (i % 2 == 1) countOdd++;
            else countOdd = 0;
            if (countOdd == 3) return true;
        }
        return false;
    }
}