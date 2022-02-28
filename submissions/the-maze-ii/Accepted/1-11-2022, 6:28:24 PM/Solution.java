// https://leetcode.com/problems/the-maze-ii

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] visited = new int[maze.length][maze[0].length];
        for (int[] row: visited)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = 0;
        int[][] dirs = {{0 , 1}, {0 , -1}, {1, 0}, {- 1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                int count = 0;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                if (visited[curr[0]][curr[1]] + count < visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = visited[curr[0]][curr[1]] + count;
                }
            }
        }
        return visited[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : visited[destination[0]][destination[1]];
    }
}