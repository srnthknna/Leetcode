// https://leetcode.com/problems/third-maximum-number

class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> max = new HashSet<>();
        for (int num : nums) {
            max.add(num);
            if (max.size() > 3) {
                max.remove(Collections.min(max));
            }
        }
        return Collections.min(max);
    }
}