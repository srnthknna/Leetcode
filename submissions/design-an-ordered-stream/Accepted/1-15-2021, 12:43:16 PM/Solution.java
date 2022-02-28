// https://leetcode.com/problems/design-an-ordered-stream

class OrderedStream {
    
    String[] map;
    int ptr = 0;

    public OrderedStream(int n) {
        map = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        int i = id - 1;
        map[i] = value;
        List<String> result = new ArrayList<>();
        while (i < map.length && i == ptr && map[i] != null) {
            result.add(map[i]); 
            i++;
            ptr++;
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */