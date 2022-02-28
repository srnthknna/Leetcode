// https://leetcode.com/problems/missing-number-in-arithmetic-progression

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        int expected = arr[0];
        
        for (int val: arr) {
            if (val != expected) return expected;
            expected += diff;
        }
        return expected;
    }
}