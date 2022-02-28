// https://leetcode.com/problems/moving-average-from-data-stream

class MovingAverage {
    
    Queue<Integer> queue;
    int size = 0, windowsum = 0, count = 0;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
    }
    
    public double next(int val) {
        ++count;
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;
        windowsum = windowsum - tail + val;
        return windowsum * 1.0 / Math.min(size, count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */