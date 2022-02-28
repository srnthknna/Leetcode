// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60

class Solution {
    // public int numPairsDivisibleBy60(int[] time) {
    //     int count = 0, n = time.length;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             if ((time[i] + time[j]) % 60 == 0) count++;
    //         }
    //     }
    //     return count;
    // }
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) count += remainder[0];
            else {
                count += remainder[60 - t % 60];
            }
            remainder[t % 60]++;
        }
        return count;
    }
}