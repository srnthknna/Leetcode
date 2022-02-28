// https://leetcode.com/problems/k-closest-points-to-origin

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> (-p2[0] + p2[0] - p1[0] + p1[0] ));
        return Arrays.copyOfRange(points, points.length - K, points.length);
    }
    
    // public int[][] kClosest(int[][] points, int K) {
    //     PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1] );
    //     for (int[] point : points) {
    //         pq.offer(point);
    //         if (pq.size() > K) {
    //             pq.poll();
    //         }
    //     }
    //     int[][] result = new int[K][2];
    //     while (K > 0) {
    //         result[--K] = pq.poll();
    //     }
    //     return result;
    // }

}