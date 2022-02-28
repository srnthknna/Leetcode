// https://leetcode.com/problems/put-boxes-into-the-warehouse-i

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = boxes.length, m = warehouse.length;
        int res = 0;
        Arrays.sort(boxes);
        for (int i = n - 1; i >= 0 && res < m; i--) {
            if (boxes[i] <= warehouse[res])
                res++;
        }
        return res;
    }
}