// https://leetcode.com/problems/campus-bikes

class Solution {
    
    // https://www.youtube.com/watch?v=Ej9R8SxP9c0&ab_channel=happygirlzt
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[] res = new int[n];
        boolean[] assigned = new boolean[n];
        boolean[] occupied = new boolean[m];
        
        List<int[]>[] distance = new List[2001];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = calDist(workers[i], bikes[j]);
                if (distance[dist] == null) {
                    distance[dist] = new ArrayList<>();
                }
                distance[dist].add(new int[] {i, j});
            }
        }
        
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == null) continue;
            int size = distance[i].size();
            for (int j = 0; j < size; j++) {
                int w = distance[i].get(j)[0];
                int b = distance[i].get(j)[1];
                if (!assigned[w] && !occupied[b]) {
                    res[w] = b;
                    assigned[w] = true;
                    occupied[b] = true;
                }
            }
        }
        return res;
    }
    
    private int calDist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}