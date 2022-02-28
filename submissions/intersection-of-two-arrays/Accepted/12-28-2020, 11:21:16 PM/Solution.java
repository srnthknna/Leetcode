// https://leetcode.com/problems/intersection-of-two-arrays

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        for (int nums : nums1) {
            nums1Set.add(nums);
        }
        
        Set<Integer> intersection = new HashSet<>();
        for (int nums : nums2) {
            if (nums1Set.contains(nums)) {
                intersection.add(nums);
            }
        }
        
        int[] ret = new int[intersection.size()];
        int i = 0;
        for (int nums : intersection) {
            ret[i++] = nums;
        }
        return ret;
    }
}