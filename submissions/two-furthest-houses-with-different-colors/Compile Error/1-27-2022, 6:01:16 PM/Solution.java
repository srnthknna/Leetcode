// https://leetcode.com/problems/two-furthest-houses-with-different-colors

class Solution {
    public int maxDistance(int[] colors) {
        int n = A.length, i = 0, j = n - 1;
        while (A[0] == A[j]) j--;
        while (A[n - 1] == A[i]) i++;
        return Math.max(n - 1 - i, j);
    }
}