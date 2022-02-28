// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
    
    List<Integer> list;
    double sum;

    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList();
        sum = 0;
    }
    
    public void addNum(int num) {
        list.add(num);
        sum += num;
        
    }
    
    public double findMedian() {
        return sum / list.size();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */