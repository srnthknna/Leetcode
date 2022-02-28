// https://leetcode.com/problems/high-five

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> scores = new TreeMap<>();
        
        for (int[] item : items) {
            if (!scores.containsKey(item[0])) {
                scores.put(item[0], new PriorityQueue<Integer>());
            }
            scores.get(item[0]).add(item[1]);
        }
        
        int[][] result = new int[scores.size()][2];
        int index = 0;
        for (int id : scores.keySet()) {
            int sum = 0;
            while (scores.get(id).size() > 5) {
                scores.get(id).poll();
            }
            for (int i : scores.get(id)) {
                sum += i;
            }
            result[index][0] = id;
            result[index][1] = sum / 5;
            index++;
        }
        return result;
    }
}