// https://leetcode.com/problems/crawler-log-folder

class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../") && count > 0) {
                count--;
            } else if (log.equals("./")) {
                
            } else {
                count++;
            }
        }
        return count;
    }
}