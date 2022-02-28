// https://leetcode.com/problems/design-an-ordered-stream

class OrderedStream {
    
    Map<Integer, String> map;
    int index = 1;

    public OrderedStream(int n) {
        map = new HashMap<>();
    }
    
    public List<String> insert(int id, String value) {
        map.put(id, value);
        List<String> result = new ArrayList<>();
        while (map.containsKey(index))
            result.add(map.get(index++));
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */