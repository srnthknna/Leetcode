// https://leetcode.com/problems/partition-array-into-disjoint-intervals

class Solution {
    public int partitionDisjointExtraSpace(int[] arr) {
        int n = arr.length, rightMin[] = new int[n + 1], leftMax = Integer.MIN_VALUE, ans = 0;
        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax <= rightMin[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans + 1;
    }
    
    public int partitionDisjoint(int[] arr) {
        int n = arr.length, leftMax = arr[0], greater = arr[0], ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > greater) {
                greater = arr[i];
            } else if (arr[i] < leftMax) {
                ans = i;
                leftMax = greater;
            }
        }

        return ans + 1;
    }
}