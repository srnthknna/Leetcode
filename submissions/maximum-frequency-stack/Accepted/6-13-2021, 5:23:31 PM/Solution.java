// https://leetcode.com/problems/maximum-frequency-stack

class FreqStack {

    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> group;
    int maxFrequency;

    public FreqStack() {
        frequency = new HashMap<>();
        group = new HashMap<>();
        maxFrequency = 0;
    }
    
    public void push(int val) {
        int f = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, f);

        if (f > maxFrequency)
            maxFrequency = f;

        group.computeIfAbsent(f, st -> new Stack<>()).push(val);
    }
    
    public int pop() {
        int top = group.get(maxFrequency).pop();

        frequency.put(top, frequency.get(top) - 1);
        if (group.get(maxFrequency).size() == 0)
            maxFrequency--;
        return top;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */