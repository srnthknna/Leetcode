// https://leetcode.com/problems/baseball-game

class Solution {
    public int calPoints(String[] ops) {
       Stack<Integer> st = new Stack<>();
        
        for (String op : ops) {
            if (op.equals("C")) {
                st.pop();
            } else if (op.equals("D")) {
                st.add(st.peek() * 2);
            } else if (op.equals("+")) {
                int top = st.pop();
                int sum = top + st.peek();
                st.add(top);
                st.add(sum);
            } else {
                st.add(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        
        return sum;
    }
}