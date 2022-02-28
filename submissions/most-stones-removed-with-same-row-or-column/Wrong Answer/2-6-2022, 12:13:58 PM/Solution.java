// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column

class Solution {
    class UF {
        Map<Integer, Integer> map;
        int size;
        public UF() {
            map = new HashMap<>();
            size = 0;
        }
        
        public int find(int x) {
            if (map.putIfAbsent(x, x) == null) {
                size++;
            }
            if (x != map.get(x)) {
                map.put(x, find(map.get(x)));
            }
            return map.get(x);
        }
        
        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                map.put(x, y);
                size--;
            }
        }
    }
    public int removeStones(int[][] stones) {
        UF uf = new UF();
        for (int[] stone : stones)
            uf.union(stone[0] + 1, 1 - stone[1]);
        return stones.length - uf.size;
    }
}