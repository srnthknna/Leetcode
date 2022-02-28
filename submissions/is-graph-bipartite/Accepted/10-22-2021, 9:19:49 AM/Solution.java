// https://leetcode.com/problems/is-graph-bipartite

class Solution {
            class UnionFind {
        int count;
        int[] root;
        int[] rank;
        
        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int findx = find(x);
            int findy = find(y);
            if (findx != findy) {
                if (rank[findx] > rank[findy]) {
                    root[findy] = findx;
                } else if (rank[findx] < rank[findy]) {
                    root[findx] = findy;
                } else {
                    root[findy] = findx;
                    rank[findx] += 1;
                }
                count--;
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        UnionFind uf = new UnionFind(100);
        for (int i = 0; i < graph.length; i++) {
            int[] nodes = graph[i];
            for (int n : nodes) {
                if (uf.find(i) == uf.find(n)) return false;
                uf.union(n, nodes[0]);
            }
        }
        return true;
    }
}