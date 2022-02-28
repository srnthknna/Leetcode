// https://leetcode.com/problems/unique-binary-search-trees

class Solution {
    public int numTreesFun(int n) {
        long c = 1;
        for (int i = 1; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) c;
    }
    
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                g[i] += g[j - 1] * g[i - j];
        }
        return g[n];
    }
}