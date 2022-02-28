// https://leetcode.com/problems/combination-sum-ii

class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(output, candidates, new ArrayList<>(), target, 0);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, int[] candidates, List<Integer> temp, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) output.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
                temp.add(candidates[i]);
                backtrack(output, candidates, temp, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}