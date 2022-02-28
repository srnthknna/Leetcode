// https://leetcode.com/problems/snapshot-array

class SnapshotArray {

    int snapId, maxIndex;
    Map<Integer, List<Integer>> snapArr;
    int[] currArr;
    public SnapshotArray(int length) {
        snapArr = new HashMap<>();
        snapId = -1;
        maxIndex = 1;
        currArr = new int[length];
    }
    
    public void set(int index, int val) {
        currArr[index] = val;
        maxIndex = Math.max(maxIndex, index);
    }
    
    public int snap() {
        snapId++;
        List<Integer> newArr = new ArrayList<>();
        for (int i = 0; i < maxIndex; i++)
            newArr.add(currArr[i]);
        snapArr.put(snapId, newArr);
        return snapId;
    }
    
    public int get(int index, int snap_id) {
        List<Integer> currSnap = snapArr.get(snap_id);
        if (index < currSnap.size()) {
            return currSnap.get(index);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */