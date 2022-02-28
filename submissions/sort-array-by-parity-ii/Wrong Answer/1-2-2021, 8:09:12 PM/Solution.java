// https://leetcode.com/problems/sort-array-by-parity-ii

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = A.length - 1;
        int count = 0;
        while (i < j) {
            if (count % 2 == 0) {
                if (A[i] % 2 > A[j] % 2) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }

                if (A[i] % 2 == 0) i++;
                if (A[j] % 2 == 1) j--;
            } else {
                if (A[i] % 2 < A[j] % 2) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }

                if (A[i] % 2 == 1) i++;
                if (A[j] % 2 == 0) j--;
            }
            count++;
        }
        return A;
    }
}