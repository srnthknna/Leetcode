// https://leetcode.com/problems/teemo-attacking

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int total = 0;
        
        if (n == 0) return 0;
        
        for (int i = 0; i < n - 1; i++) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return total += duration;
    }
}