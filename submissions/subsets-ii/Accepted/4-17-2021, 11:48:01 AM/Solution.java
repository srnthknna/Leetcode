// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, output, new ArrayList<>());
        return output;
    }
    
    private void helper(int index, int[] nums, List<List<Integer>> output, List<Integer> arr) {
        output.add(new ArrayList<>(arr));
        
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            arr.add(nums[i]);
            helper(i + 1, nums, output, arr);
            arr.remove(arr.size() - 1);
        }
    }
}