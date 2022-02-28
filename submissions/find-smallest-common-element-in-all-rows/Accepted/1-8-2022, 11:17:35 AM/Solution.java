// https://leetcode.com/problems/find-smallest-common-element-in-all-rows

class Solution {
    public int smallestCommonElement(int[][] mat) {
        if (mat == null || mat.length == 0) return -1;
        
        Set<Integer> row1 = new HashSet<>();
        for (int num : mat[0])
            row1.add(num);
        
        for (int i = 1; i < mat.length; i++) {
            if (!row1.isEmpty()) {
                Set<Integer> nextRow = new HashSet<>();
                for (int num : mat[i])
                    nextRow.add(num);
                row1.retainAll(nextRow);
            }
        }
        
        return row1.isEmpty() ? -1 : Collections.min(row1);
    }
}