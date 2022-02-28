// https://leetcode.com/problems/matrix-cells-in-distance-order

class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[][] result = new int[R*C][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r0, c0});
        int i = 0;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c])
                continue;
            
            result[i++] = cell;
            visited[r][c] = true;
            
            queue.offer(new int[] {r - 1, c});
            queue.offer(new int[] {r + 1, c});
            queue.offer(new int[] {r, c - 1});
            queue.offer(new int[] {r, c + 1});
        }
        return result;
    }
}