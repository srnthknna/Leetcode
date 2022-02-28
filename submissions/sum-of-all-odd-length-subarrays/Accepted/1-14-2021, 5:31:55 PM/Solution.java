// https://leetcode.com/problems/sum-of-all-odd-length-subarrays

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0, sum;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if ((j - i) % 2 == 0) res += sum;
            }
        }
        return res;
    }
}