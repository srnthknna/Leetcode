// https://leetcode.com/problems/path-with-minimum-effort

class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length, col = heights[0].length, minDiff[][] = new int[row][col];
        for (int[] rows : minDiff)
            Arrays.fill(rows, Integer.MAX_VALUE);
        minDiff[0][0] = 0;
        boolean[][] visited = new boolean[row][col];
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> (a.diff - b.diff));
        pq.offer(new Cell(0, 0, minDiff[0][0]));
        
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row - 1 && curr.y == col - 1) return curr.diff;
            for (int[] dir : dirs) {
                int nextX = curr.x + dir[0], nextY = curr.y + dir[1];
                if (isValid(nextX, nextY, row, col) && !visited[nextX][nextY]) {
                    int currDiff = Math.abs(heights[nextX][nextY] - heights[curr.x][curr.y]);
                    int maxDiff = Math.max(currDiff, minDiff[curr.x][curr.y]);
                    if (maxDiff < minDiff[nextX][nextY]) {
                        pq.offer(new Cell(nextX, nextY, maxDiff));
                        minDiff[nextX][nextY] = maxDiff;
                    }
                }
            }
        }
        return minDiff[row - 1][col - 1];
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