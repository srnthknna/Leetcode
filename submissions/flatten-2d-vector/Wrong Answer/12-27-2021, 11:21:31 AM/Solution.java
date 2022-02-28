// https://leetcode.com/problems/flatten-2d-vector

import java.util.NoSuchElementException;
class Vector2D {
    int[][] vectors;
    int inner = 0;
    int outer = 0;

    public Vector2D(int[][] vec) {
        vectors = vec;
    }
    
    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        return vectors[outer][inner++];
    }
    
    private void advanceNext() {
        if (outer < vectors.length && inner == vectors[outer].length) {
            inner = 0;
            outer++;
        }
    }
    
    public boolean hasNext() {
        advanceNext();
        return outer < vectors.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */