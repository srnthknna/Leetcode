// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

// General n2 solution with space k
class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pq.size() < k) {
                    pq.offer(matrix[i][j]);
                } else {
                    if (pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, start = matrix[0][0], end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int[] smallLargePair = new int[] {matrix[0][0], matrix[n - 1][n - 1]};
            
            int count = countLessEqual(smallLargePair, matrix, mid);
            
            if (count == k) return smallLargePair[0];
            
            if (count < k) start = smallLargePair[1];
            else end = smallLargePair[0];
        }
        return start;
    }
    
    private int countLessEqual(int[] smallLargePair, int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }
}