// https://leetcode.com/problems/lexicographical-numbers

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(i, n, answer);
        return answer;
    }
    
    private void dfs(int curr, int n, List<Integer> answer) {
        if (curr > n) return;
        answer.add(curr);
        for (int i = 0; i < 10; i++)
            dfs(curr * 10 + i, n, answer);
    }
}