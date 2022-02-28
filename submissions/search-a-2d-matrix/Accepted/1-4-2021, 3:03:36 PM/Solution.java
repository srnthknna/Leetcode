// https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0) return false;
        
        int left = 0, right = matrix.length * matrix[0].length - 1, pivotIdx, pivot;
        
        while (left <= right) {
            pivotIdx = left + (right - left) / 2;
            pivot = matrix[pivotIdx / matrix[0].length][pivotIdx % matrix[0].length];
            
            if (target == pivot) return true;
            else {
                if (target < pivot) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }
}