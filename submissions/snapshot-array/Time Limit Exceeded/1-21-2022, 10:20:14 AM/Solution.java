// https://leetcode.com/problems/snapshot-array

class SnapshotArray {
    
    List<List<Integer>> snap;
    List<Integer> curr;

    public SnapshotArray(int length) {
        curr = new ArrayList<>();
        snap = new ArrayList<>();
        for (int i = 0; i < length; i++)
            curr.add(0);
    }
    
    public void set(int index, int val) {
        curr.set(index, val);
    }
    
    public int snap() {
        snap.add(new ArrayList<>(curr));
        return snap.size() - 1;
    }
    
    public int get(int index, int snap_id) {
        return snap.get(snap_id).get(index);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */