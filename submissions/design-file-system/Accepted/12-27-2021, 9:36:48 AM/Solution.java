// https://leetcode.com/problems/design-file-system

class FileSystem {
    
    Map<String, Integer> paths = new HashMap<>();

    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        if (path.isEmpty() || (path.length() == 1 && path.equals("/")) || paths.containsKey(path)) {
            return false;
        }
        
        int delim = path.lastIndexOf("/");
        String parent = path.substring(0, delim);
        
        if (parent.length() > 1 && !paths.containsKey(parent)) {
            return false;
        }
        paths.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */