// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1;
        for (int num : nums) {
            right = Math.max(right, num);
            left = Math.min(left, num);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDist(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canDist(int[] nums, int k, int n) {
        int ops = 0;
        for (int num : nums) {
            ops += (num - 1) / k;
        }
        return ops <= n;
    }
}