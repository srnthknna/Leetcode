// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

class Solution {
    private static int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length, col = grid[0].length;
        if (row == 0 || col == 0) return 0;
        
        boolean[][] visited = new boolean[row][col];
        int[][] obstacle = new int[row][col];
        obstacle[0][0] = grid[0][0];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, obstacle[0][0]});

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                if (curr[0] == row - 1 && curr[1] == col - 1) {
                    return level;
                }
                
                for (int[] dir : DIRS) {
                    int nextX = dir[0] + curr[0], nextY = dir[1] + curr[1];
                    
                    if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) {
                        continue;
                    }
                    
                    int oldObstacle = obstacle[nextX][nextY], 
                        newObstacle = curr[2] + grid[nextX][nextY];
                    
                    if (!visited[nextX][nextY] && newObstacle <= k || 
                        oldObstacle > newObstacle && newObstacle <= k) {
                        
                        obstacle[nextX][nextY] = newObstacle;
                        queue.offer(new int[] {nextX, nextY, newObstacle});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}