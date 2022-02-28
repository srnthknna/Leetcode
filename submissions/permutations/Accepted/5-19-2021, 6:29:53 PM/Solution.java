// https://leetcode.com/problems/permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> nums_list = new ArrayList<>();
        for (int num : nums) nums_list.add(num);
        backtrack(nums.length, nums_list, output, 0);
        return output;
    }
    
    private void backtrack(int n, List<Integer> nums_list, List<List<Integer>> output, int start) {
        if (n == start) output.add(new ArrayList<>(nums_list));
        
        for (int i = start; i < n; i++) {
            Collections.swap(nums_list, start, i);
            backtrack(n, nums_list, output, start + 1);
            Collections.swap(nums_list, start, i);
        }
        
    }
}