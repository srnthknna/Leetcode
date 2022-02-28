// https://leetcode.com/problems/combination-sum-iii

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, List<Integer> comb, int k, int n, int start) {
        if (n < 0) 
            return;
        if (n == 0 && k == comb.size()) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        
        for (int i = start; i < 10; i++) {
            comb.add(i);
            helper(ans, comb, k, n - i, i + 1);
            comb.remove(comb.size() - 1);
        } 
    }
}