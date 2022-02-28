// https://leetcode.com/problems/put-boxes-into-the-warehouse-i

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = boxes.length, m = warehouse.length;
        int res = 0;
        Arrays.sort(boxes);
        for (int i = 0; i < n && res < m; i++) {
            if (boxes[n - i - 1] <= warehouse[res])
                res++;
        }
        return res;
    }
}