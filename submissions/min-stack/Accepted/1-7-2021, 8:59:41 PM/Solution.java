// https://leetcode.com/problems/min-stack

class MinStack {

    Stack<Integer> stack = new Stack<>(), mins = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty() || mins.peek() >= x) {
            mins.push(x);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (mins.peek() == val) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */