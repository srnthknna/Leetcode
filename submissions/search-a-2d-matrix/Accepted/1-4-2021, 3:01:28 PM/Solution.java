// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        
        if (m == 0) return false;
        
        int n = matrix[0].length;
        
        int left = 0, right = m * n - 1, pivotIdx, pivot;
        
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivot = matrix[pivotIdx / n][pivotIdx % n];
            
            if (target == pivot) return true;
            else {
                if (target < pivot) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}