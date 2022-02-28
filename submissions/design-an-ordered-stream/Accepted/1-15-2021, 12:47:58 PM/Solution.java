// https://leetcode.com/problems/design-an-ordered-stream

class OrderedStream {
    
    String[] map;
    int ptr = 1;

    public OrderedStream(int n) {
        map = new String[n + 1];
    }
    
    public List<String> insert(int id, String value) {
        map[id] = value;
        List<String> result = new ArrayList<>();
        
        if(map[ptr] == null){
            return result;
        }
        
        while (ptr < map.length && map[ptr] != null) {
            result.add(map[ptr++]); 
        }
        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */