// https://leetcode.com/problems/sum-of-even-numbers-after-queries

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sum = 0, i = 0;
        
        for (int val : A) 
            if (val % 2 == 0) 
                sum += val;
        
        for (int[] query : queries) {
            int val = query[0], index = query[1];
            if (A[index] % 2 == 0) 
                sum -= A[index];
            
            A[index] += val;
            
            if (A[index] % 2 == 0) 
                sum += A[index];

            result[i++] = sum;
        }
        
        return result;
    }
}