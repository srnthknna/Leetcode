// https://leetcode.com/problems/sum-of-even-numbers-after-queries

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int i = 0;
        for (int[] query : queries) {
            A[query[1]] += query[0];
            int count = 0;
            for (int val : A) {
                if (val % 2 == 0) count += val;
            }
            result[i++] = count;
        }
        return result;
    }
}