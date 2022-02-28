// https://leetcode.com/problems/split-array-largest-sum

class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(mid, nums, m)) {
                right = mid;
            } else 
                left = mid + 1;
        }
        return left;
    }
    
    private boolean canSplit(int max, int[] nums, int m) {
        int total = 0, count = 1;
        for (int num : nums) {
            if (total + num > max) {
                total = 0;
                count++;
            }
            total += num;
            if (count > m) return false;
        }
        return true;
    }
}