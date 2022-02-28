// https://leetcode.com/problems/put-boxes-into-the-warehouse-ii

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = boxes.length, m = warehouse.length;
        int res = 0, p1 = 0, p2 = m - 1;
        Arrays.sort(boxes);
        for (int i = 0; i < n && res < m && p1 <= p2; i++) {
            if (boxes[n - i - 1] <= warehouse[p1]) {
                res++;
                p1++;
            } else if (boxes[n - i - 1] <= warehouse[p2]) {
                res++;
                p2--;
            }
        }
        return res;
    }
}