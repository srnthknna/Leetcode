// https://leetcode.com/problems/3sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1, high = nums.length - 1;
        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            } else {
                res.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            }
        }
    }
}