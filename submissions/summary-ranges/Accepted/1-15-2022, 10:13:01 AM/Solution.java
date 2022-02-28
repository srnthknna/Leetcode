// https://leetcode.com/problems/summary-ranges

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            i = j;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            if (i == j) {
                result.add(nums[i] + "");
            } else {
                result.add(nums[i] + "->" + nums[j]);
            }
        }
        return result;
    }
}