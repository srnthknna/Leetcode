// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(output, new ArrayList<>(), nums, 0);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, List<Integer> temp, int[] nums, int start) {
        output.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(output, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}