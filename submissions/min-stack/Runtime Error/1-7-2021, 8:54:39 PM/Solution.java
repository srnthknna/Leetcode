// https://leetcode.com/problems/min-stack

class MinStack {

    Stack<Integer> stack, mins;
    
    /** initialize your data structure here. */
    public MinStack() {
        mins = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (!mins.isEmpty() && mins.peek() > x) {
            mins.push(x);
        } else if (mins.isEmpty()) {
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