// https://leetcode.com/problems/design-a-stack-with-increment-operation

class CustomStack {
    
    int[] arr;
    int top;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if (!isFull())
            arr[++top] = x;
    }
    
    public int pop() {
        return isEmpty() ? -1 : arr[top--];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < k && i < arr.length; i++)
            arr[i] += val;
    }
    
    private boolean isFull() {
        return top == arr.length - 1;
    }
    
    private boolean isEmpty() {
        return top == -1;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */