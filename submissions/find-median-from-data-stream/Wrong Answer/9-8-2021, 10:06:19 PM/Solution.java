// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        if (!minHeap.isEmpty() && num < minHeap.peek()) {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size())
                minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size())
            return minHeap.peek();
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */