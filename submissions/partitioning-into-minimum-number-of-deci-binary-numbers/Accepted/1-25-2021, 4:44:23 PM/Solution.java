// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers

class Solution {
    public int minPartitions(String n) {
        int result = 0;
        for (char c : n.toCharArray()) {
            result = Math.max(result, c - '0');
        }
        return result;
    }
}