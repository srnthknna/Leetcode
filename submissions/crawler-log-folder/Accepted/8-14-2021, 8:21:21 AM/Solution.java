// https://leetcode.com/problems/crawler-log-folder

class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../"))
                count = Math.max(0, --count);
            else if (log.equals("./"))
                continue;
            else
                count++;
        }
        return count;
    }
}