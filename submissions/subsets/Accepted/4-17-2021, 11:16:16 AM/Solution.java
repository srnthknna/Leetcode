// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            
            output.addAll(newSubsets);
        }
        return output;
    }
}