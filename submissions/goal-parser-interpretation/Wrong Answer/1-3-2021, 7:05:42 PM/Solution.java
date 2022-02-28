// https://leetcode.com/problems/goal-parser-interpretation

class Solution {
    public String interpret(String command) {
        //return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
        StringBuilder sb = new StringBuilder();
        
        char c;
        for (int i = 0; i < command.length() - 1; i++) {
            c = command.charAt(i);
            if (c == 'G') {
                sb.append(c);
            } else if (c == 'a') {
                i += 2;
                sb.append("al");
            } else if (c == ')') {
                sb.append('o');
            }
        }
        return sb.toString();
    }
}