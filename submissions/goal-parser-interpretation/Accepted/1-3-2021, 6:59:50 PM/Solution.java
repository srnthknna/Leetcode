// https://leetcode.com/problems/goal-parser-interpretation

class Solution {
    public String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }
}