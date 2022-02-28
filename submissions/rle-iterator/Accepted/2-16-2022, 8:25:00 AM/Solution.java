// https://leetcode.com/problems/rle-iterator


// https://www.youtube.com/watch?v=Y_x4H9nMps0&ab_channel=NareshGupta
// very good explanation of this problem
// Approach 1 brute force simulate and generate the array
// Approach 2 create a treemap and use the ceilingkey to get the next value
// Approach 3 current have ability to modify the given arr to check if we need to iterate
class RLEIteratorWithArrayModification {

    int arr[];
    int index = 0;
    public RLEIteratorWithArrayModification(int[] encoding) {
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

// check up its for learning
// Approach 4 without modifying the given arr
class RLEIterator {

    int arr[];
    int index = 0;
    int count;
    public RLEIterator(int[] encoding) {
        arr = encoding;
        count = arr[0];
    }
    
    public int next(int n) {
        while (index < arr.length) {
            if (n > count) {
                n -= count;
                index += 2;
                if (index < arr.length) {
                    count = arr[index];
                }
            } else {
                count -= n;
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