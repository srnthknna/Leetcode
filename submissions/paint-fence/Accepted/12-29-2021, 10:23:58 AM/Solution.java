// https://leetcode.com/problems/paint-fence

class Solution {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        
        int oneBack = k * k;
        int twoBack = k;
        
        for (int i = 3; i <= n; i++) {
            int curr = (k - 1) * (oneBack + twoBack);
            twoBack = oneBack;
            oneBack = curr;
        }
        
        return oneBack;
    }
}