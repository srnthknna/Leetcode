// https://leetcode.com/problems/lexicographical-numbers

class Solution {
    // https://www.youtube.com/watch?v=gRo86WqFYSE&list=PL-Jc9J83PIiE-181crLG1xSIWhTGKFiMY&index=5&ab_channel=Pepcoding
    public List<Integer> lexicalOrderRecursion(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < 10; i++)
            dfs(i, n, answer);
        return answer;
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1, curr = 1; i <= n; i++) {
            answer.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 == 9 || curr == n) {
                while (curr % 10 == 9 || curr == n) {
                    curr /= 10;
                }
                curr++;
            } else if (curr < n) {
                curr++;
            }
        }
            
        return answer;
    }
    
    private void dfs(int curr, int n, List<Integer> answer) {
        if (curr > n) return;
        answer.add(curr);
        for (int i = 0; i < 10; i++)
            dfs(curr * 10 + i, n, answer);
    }
}