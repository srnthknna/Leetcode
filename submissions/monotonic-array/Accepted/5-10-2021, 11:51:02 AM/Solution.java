// https://leetcode.com/problems/monotonic-array

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true, decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) increasing =  false;
            if (A[i] < A[i + 1]) decreasing =  false;
        }
        return increasing || decreasing;
    }
}