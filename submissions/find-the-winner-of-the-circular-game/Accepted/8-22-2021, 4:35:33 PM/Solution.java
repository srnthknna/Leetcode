// https://leetcode.com/problems/find-the-winner-of-the-circular-game

class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            num.add(i);
        int cur = -1;
        
        while (num.size() > 1) {
            int size = num.size();
            cur = (cur + k) % size;
            num.remove(cur);
            cur = cur == 0 ? size - 2: cur - 1;
        }
        return num.get(0);
    }
}