// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid

class Solution {
    private static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int minCost(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if (row == 0 || col == 0) return 0;
        
        int[][] cost = new int[row][col];
        for (int[] rows : cost)
            Arrays.fill(rows, Integer.MAX_VALUE);
        cost[0][0] = 0;
        
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (cost[a[0]][a[1]] - cost[b[0]][b[1]]));
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            int currCost = curr[2];
            
            //if (curr[0] == row - 1 && curr[1] == col - 1) return curr[2];

            for (int i = 0; i < DIRS.length; i++) {
                int[] dir = DIRS[i];
                int nextCost = curr[2];
                int nextX = curr[0] + dir[0], nextY = curr[1] + dir[1];
                if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
                
                if (i + 1 != grid[curr[0]][curr[1]]) {
                    nextCost += 1;
                }
                
                if (!visited[nextX][nextY] && nextCost < cost[nextX][nextY]) {
                    queue.offer(new int[] {nextX, nextY, nextCost});
                    cost[nextX][nextY] = nextCost;
                } else if (nextCost < cost[nextX][nextY]) {
                    queue.offer(new int[] {nextX, nextY, nextCost});
                    cost[nextX][nextY] = nextCost;
                }
            }
        }
        return cost[row - 1][col - 1];
    }
}