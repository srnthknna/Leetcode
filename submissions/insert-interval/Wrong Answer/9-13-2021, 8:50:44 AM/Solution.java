// https://leetcode.com/problems/insert-interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for (int[] i : intervals) {
            if (newInterval == null || i[1] < newInterval[0])
                result.add(i);
            else if (i[0] > newInterval[0]) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            }
        }
        
        if (newInterval != null)
            result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}