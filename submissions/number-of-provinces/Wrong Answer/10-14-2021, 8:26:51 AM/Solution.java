// https://leetcode.com/problems/number-of-provinces

class Solution {
    // Quick union is needed to assign the same parent root value to all the nodes in a set
    class UnionFind {
        int root[];
        
        public UnionFind(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int find(int x) {
            while (x != root[x]) {
                x = root[x];
            }
            return x;
        }
        
        public void union(int x, int y) {
            int findx = find(x);
            int findy = find(y);
            if (findx != findy) {
                root[findy] = findx;
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        UnionFind sets = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    sets.union(i, j);
                }
            }
        }
        
        Set<Integer> answer = new HashSet();
        for (int i : sets.root)
            answer.add(i);
        return answer.size();
    }
}