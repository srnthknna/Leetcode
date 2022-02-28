// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 1;
        for (int q : quantities) {
            right = Math.max(right, q);
        }
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (canDist(quantities, mid, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canDist(int[] quantities, int k, int n) {
        for (int q : quantities) {
            n -= 1 + (q - 1) / k;
        }
        return n >= 0;
    }
}