// https://leetcode.com/problems/random-pick-with-weight

class Solution {
    int[] prefixsum;
    int totalsum;

    public Solution(int[] w) {
        prefixsum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixsum[i] = sum;
        }
        totalsum = sum;
    }
    
    public int pickIndex() {
        double random = totalsum * Math.random();
        
        int low = 0, high = prefixsum.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (random > prefixsum[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */