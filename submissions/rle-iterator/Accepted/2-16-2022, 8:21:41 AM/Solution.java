// https://leetcode.com/problems/rle-iterator

class RLEIterator {

    int arr[];
    int index = 0;
    public RLEIterator(int[] encoding) {
        arr = encoding;
    }
    
    public int next(int n) {
        while (index < arr.length) {
            if (n > arr[index]) {
                n -= arr[index];
                index += 2;
            } else {
                arr[index] -= n;
                return arr[index + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */