// https://leetcode.com/problems/task-scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        
        for (char c : tasks) {
            hash[c - 'A']++;
        }

        Arrays.sort(hash);
        int maxVal = hash[25] -  1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && hash[i] > 0; i--) {
            idleSlots -= Math.min(maxVal, hash[i]);
        }
        
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}