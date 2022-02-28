// https://leetcode.com/problems/zigzag-iterator

public class ZigzagIterator {
    List<List<Integer>> vectors = new ArrayList<>();
    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectors.add(v1);
        vectors.add(v2);
        int index = 0;
        for (List<Integer> vec : vectors) {
            if (vec.size() > 0) {
                queue.add(new Pair<>(index, 0));
            }
            index++;
        }
    }

    public int next() {
        Pair<Integer, Integer> pointer = queue.remove();
        int vecIndex = pointer.getKey();
        int elemIndex = pointer.getValue();
        int nextElemIndex = elemIndex + 1;
        
        if (nextElemIndex < vectors.get(vecIndex).size()) {
            queue.add(new Pair<>(vecIndex, nextElemIndex));
        }
        return vectors.get(vecIndex).get(elemIndex);
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */