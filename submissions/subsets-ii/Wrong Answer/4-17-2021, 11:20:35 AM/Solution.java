// https://leetcode.com/problems/subsets-ii

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());
        
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            
            for (List<Integer> curr : newSubsets) {
                if (!output.contains(curr))
                output.add(curr);
            }
        }
        return output;
    }
}