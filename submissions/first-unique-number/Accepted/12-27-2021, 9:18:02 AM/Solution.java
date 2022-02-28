// https://leetcode.com/problems/first-unique-number

class FirstUnique {
    Set<Integer> setQueue = new LinkedHashSet<>();
    Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if (!setQueue.isEmpty()) {
            return setQueue.iterator().next();
        }
        return -1;
    }
    
    public void add(int value) {
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            setQueue.add(value);
        } else {
            isUnique.put(value, false);
            setQueue.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */