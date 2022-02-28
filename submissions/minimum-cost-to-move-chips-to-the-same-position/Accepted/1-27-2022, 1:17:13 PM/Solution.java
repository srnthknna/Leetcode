// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position

class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;
        for (int pos : position) {
            if (pos % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        return Math.min(evenCount, oddCount);
    }
}