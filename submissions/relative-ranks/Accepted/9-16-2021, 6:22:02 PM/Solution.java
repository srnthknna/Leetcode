// https://leetcode.com/problems/relative-ranks

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : score) {
            pq.offer(i);
        }
        String[] ans = new String[score.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++)
            map.put(pq.poll(), i + 1);
        for (int i : score) {
            if (map.get(i) == 1)
                ans[index++] = "Gold Medal";
            else if (map.get(i) == 2)
                ans[index++] = "Silver Medal";
            else if (map.get(i) == 3)
                ans[index++] = "Bronze Medal";
            else
                ans[index++] = map.get(i) + "";
        }
        return ans;
    }
}