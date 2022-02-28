// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, hi = m * n;
        while (low < hi) {
            int mi = low + (hi - low) / 2;
            if (!enough(mi, m, n, k)) low = mi + 1;
            else hi = mi;
        }
        return low;
    }
    
    private boolean enough (int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}