// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> table = new HashSet<>();
        for (int[] i : ranges) {
            for (int j = i[0]; j <= i[1]; j++)
                table.add(j);
        }
        
        for (int i = left; i <= right; i++)
            if (!table.contains(i))
                return false;
        
        return true;
    }
}