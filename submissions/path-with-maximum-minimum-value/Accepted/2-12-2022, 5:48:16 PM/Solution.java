// https://leetcode.com/problems/path-with-maximum-minimum-value

class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maximumMinimumPath(int[][] grid) {
        int row = grid.length, col = grid[0].length, minDiff = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[row][col];
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (-a.diff + b.diff));
        pq.offer(new Cell(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            visited[curr.x][curr.y] = true;
            minDiff = Math.min(curr.diff, minDiff);
            if (curr.x == row - 1 && curr.y == col - 1) return minDiff;
            for (int[] dir : dirs) {
                int nextX = curr.x + dir[0], nextY = curr.y + dir[1];
                if (isValid(nextX, nextY, row, col) && !visited[nextX][nextY]) { 
                    pq.offer(new Cell(nextX, nextY, grid[nextX][nextY]));
                }
            }
        }
        return minDiff;
    }
    
    private boolean isValid(int x, int y, int row, int col) {
        if (x < 0 || y < 0 || x >= row || y >= col) return false;
        return true;
    }
    
    class Cell {
        int x, y, diff;
        public Cell(int x, int y, int diff) {
            this.x = x;
            this.y = y;
            this.diff = diff;
        }
    }
}