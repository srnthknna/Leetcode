// https://leetcode.com/problems/baseball-game

class Solution {
    public int calPoints(String[] ops) {
       Stack<Integer> st = new Stack<>();
        int sums = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                sums -= st.pop();
            } else if (op.equals("D")) {
                st.add(st.peek() * 2);
                sums += st.peek();
            } else if (op.equals("+")) {
                int top = st.pop();
                int sum = top + st.peek();
                st.add(top);
                st.add(sum);
                sums += st.peek();
            } else {
                st.add(Integer.parseInt(op));
                sums += st.peek();
            }
        }
        
        return sums;
    }
}