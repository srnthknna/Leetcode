// https://leetcode.com/problems/combinations

class Solution {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtract(n, k, 1, new LinkedList<Integer>());
        return output;
    }

    private void backtract(int n , int k, int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            output.add(new LinkedList(curr));
        }
        
        for (int i = first; i < n + 1; i++) {
            curr.add(i);
            backtract(n , k, i + 1, curr);
            curr.removeLast();
        }
    }
}