// https://leetcode.com/problems/rotting-oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int row = grid.length, col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i ,j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int min = 0, count = 0;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {-1, 1, 0, 0};
        if (fresh == 0) return 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                
                for (int j = 0; j < 4; j++) {
                    int x = node[0] + dx[j];
                    int y = node[1] + dy[j];
                    
                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 2 || grid[x][y] == 0) continue;
                    queue.offer(new int[] {x, y});
                    grid[x][y] = 2;
                    fresh--;
                }
            }
            if (!queue.isEmpty())
                min++;
        }
        return fresh == 0 ? min : -1;
    }
}