// https://leetcode.com/problems/interval-list-intersections

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        
        while (i < firstList.length && j < secondList.length) {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            
            if (low <= hi)
                result.add(new int[] {low, hi});
            
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        
        return result.toArray(new int[result.size()][]);
    }
}