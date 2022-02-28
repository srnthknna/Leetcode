// https://leetcode.com/problems/combination-sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(output, candidates, new ArrayList<>(), target, 0);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, int[] candidates, List<Integer> temp, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            output.add(new ArrayList<>(temp));
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(output, candidates, temp, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}