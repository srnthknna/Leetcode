// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        for (int t : time) {
            remainder[t%60]++;
        }
        int count0 = remainder[0], count30 = remainder[30];
        int count = count0 * (count0 - 1)/2;
        count += count30 * (count30 - 1) / 2;
        for (int i = 1; i <= 29; i++) {
            count += remainder[i] * remainder[60 - i];
        }
        return count;
    }
}