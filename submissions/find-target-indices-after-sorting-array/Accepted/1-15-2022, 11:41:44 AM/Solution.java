// https://leetcode.com/problems/find-target-indices-after-sorting-array

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = findIndex(nums, target, true);
        int end = findIndex(nums, target, false);
        
        List<Integer> result = new ArrayList<>();
        
        if (start != -1 && end != -1) {
            for (int i = start; i <= end; i++) {
                result.add(i);
            }
        }
        return result;
    }
    
    private int findIndex(int[] nums, int target, boolean isStart) {
        int index = -1, left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (isStart) {
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}