// https://leetcode.com/problems/paint-house-ii

class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int houses = costs.length;
        int colors = costs[0].length;
        
        for (int h = 1; h < houses; h++) {
            for (int c = 0; c < colors; c++) {
                int minCurr = Integer.MAX_VALUE;
                
                for (int prevC = 0; prevC < colors; prevC++) {
                    if (c == prevC) continue;
                    minCurr = Math.min(minCurr, costs[h - 1][prevC]);
                }
                
                costs[h][c] += minCurr;
            }
        }
        
        int minFinal = Integer.MAX_VALUE;
        for (int c: costs[houses - 1]) {
            minFinal = Math.min(minFinal, c);
        }
        
        return minFinal;
    }
}